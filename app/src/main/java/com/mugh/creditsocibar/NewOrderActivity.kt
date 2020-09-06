package com.mugh.creditsocibar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.mugh.creditsocibar.Adapters.MenuAdapter
import com.mugh.creditsocibar.Adapters.MyAdapter
import com.mugh.creditsocibar.backend.OrdersServiceImpl
import com.mugh.creditsocibar.entities.Article
import com.mugh.creditsocibar.entities.ArticleView
import com.mugh.creditsocibar.entities.Menu.Menu
import com.mugh.creditsocibar.entities.Menu.MenuTypeView
import com.mugh.creditsocibar.entities.Order



class NewOrderActivity : AppCompatActivity() {

    private val ordersService = object: OrdersServiceImpl(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menu = Menu()
        val listMenuTypeView = arrayListOf<MenuTypeView>()

        val types = menu.types.iterator()
        while(types.hasNext()){
            val type = types.next()
            listMenuTypeView.add(MenuTypeView(type.key,null,type.value.description))
        }

        setContentView(R.layout.activity_new_order)

        var listMenuView = findViewById<ListView>(R.id.listMenu)

        listMenuView.adapter =
            MenuAdapter(this, R.layout.row, listMenuTypeView)

        listMenuView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id:Long->
            listMenuTypeView[position].type
        }

        //var order = Order(intent.getStringExtra(EXTRA_TABLE), arrayListOf<Article>())
        //ordersService.newOrder(order)


    }


}