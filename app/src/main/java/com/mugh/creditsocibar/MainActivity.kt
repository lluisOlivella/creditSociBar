package com.mugh.creditsocibar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.mugh.creditsocibar.Adapters.MyAdapter
import com.mugh.creditsocibar.backend.RefreshTable
import com.mugh.creditsocibar.backend.OrdersServiceImpl
import com.mugh.creditsocibar.entities.ArticleView
import com.mugh.creditsocibar.entities.Menu.Menu
import com.mugh.creditsocibar.entities.Menu.SubType
import com.mugh.creditsocibar.entities.Menu.Type
import com.mugh.creditsocibar.entities.OrderView
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.mugh.creditsocibar.MESSAGE"
const val EXTRA_TABLE = "com.mugh.creditsocibar.TABLEID"

class MainActivity : AppCompatActivity() {

    private val ordersService = object: OrdersServiceImpl(){}

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)

        ordersService.getOrders("1",object:RefreshTable{
            override fun onRefresh(order: OrderView) {
                order.articles?.forEach{
                    Log.d("MainRef","ArticleId=${it.articleId}")
                }
            }

        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listOrdersView)

        //var article01 = Article(null,"002","Cocacola",1.2, Article.Type.BEBIDA, Article.State.SOLICITADO,R.drawable.cocacola)
        //var article02 = Article(null,"001","Cafe sol",1.2, Article.Type.BEBIDA, Article.State.SOLICITADO,R.drawable.cafe)

        //var list = mutableListOf<Article>(article01,article02)
        var list = mutableListOf<ArticleView>()

        listView.adapter =
            MyAdapter(this, R.layout.row, list)

        listView.setOnItemClickListener { parent:AdapterView<*>, view:View, position:Int, id:Long->
            if(position==0)
            if(position==0){
                Toast.makeText(this@MainActivity, "You click on cafe", Toast.LENGTH_LONG).show()
            }
        }

        ordersService.getOrders("1",object:RefreshTable{
            override fun onRefresh(order: OrderView) {
                var listView2 = findViewById<ListView>(R.id.listOrdersView)
                var list2 = mutableListOf<ArticleView>()

                order.articles?.forEach{
                    Log.d("MainRef","ArticleId=${it.articleId}")
                    list2.add(it)
                }

                listView2.adapter = MyAdapter(
                    this@MainActivity,
                    R.layout.row,
                    list2
                )

            }

        })

        setup()
        val menu = Menu()
        menu.types[Type.FOOD]?.subTypes?.get(SubType.SANDWICH)

    }

    private fun setup(){
        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }


    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        // Do something in response to button
        val editText = findViewById<EditText>(R.id.idText)
        val message = editText.text.toString()
            val intent = Intent(this, NewOrderActivity::class.java).apply {
            putExtra(EXTRA_TABLE, message)
        }
        startActivity(intent)
    }

}


