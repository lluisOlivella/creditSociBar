package com.mugh.creditsocibar.backend

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.mugh.creditsocibar.entities.Article
import com.mugh.creditsocibar.entities.ArticleView
import com.mugh.creditsocibar.entities.Order
import com.mugh.creditsocibar.entities.OrderView

open class OrdersServiceImpl:OrdersService {

    private val tablesCollection = "tables"
    private val ordersCollection = "orders"
    private val logsRef = "ordersServiceImplRef"

    // Access a Cloud Firestore instance
    private val db = FirebaseFirestore.getInstance()

    override fun newOrder(order: Order) {

        order.articles!!.forEach {

            db.collection(tablesCollection).document(order.table).collection(ordersCollection)
                .add(it)
                .addOnSuccessListener { documentReference ->
                    Log.d(logsRef, "Alta articulo con ID: ${documentReference.id}")
                }.addOnFailureListener { exception ->
                    Log.d(logsRef, "Error adding document", exception)
                }

        }

    }

    override fun getOrders(table: String, refreshTable: RefreshTable) {

        var docRef = db.collection(tablesCollection).document(table).collection(ordersCollection)

        docRef.get()
            .addOnSuccessListener { result ->

                refreshTable(result.documents,refreshTable,table)

                docRef.addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Log.w(logsRef, "Listen failed.", e)
                        return@addSnapshotListener
                    }

                    if (!(snapshot?.isEmpty!!)) {
                        Log.d(logsRef, "Current data: ${snapshot.documents}")
                        refreshTable(snapshot.documents,refreshTable,table)
                    } else {
                        Log.d(logsRef, "Current data: null")
                    }
                }

            }.addOnFailureListener() { exception ->
                Log.d(logsRef, "Error adding document", exception)
            }
    }


    private fun refreshTable(documents: MutableList<DocumentSnapshot>, refreshTable: RefreshTable, table:String) {

        var articles = arrayListOf<ArticleView>()

        for (document in documents) {

            Log.d(logsRef, "${document.id} => ${document.data}")

            var article = document.toObject(Article::class.java)

            if (article != null) {
                articles.add(article.convertToArticleView(document.id))
            }

        }

        refreshTable.onRefresh(OrderView(table, articles))

    }
}