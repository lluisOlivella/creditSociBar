package com.mugh.creditsocibar.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mugh.creditsocibar.MainActivity
import com.mugh.creditsocibar.NewOrderActivity
import com.mugh.creditsocibar.R

import com.mugh.creditsocibar.entities.ArticleView
import com.mugh.creditsocibar.entities.Menu.MenuTypeView
import com.mugh.creditsocibar.entities.Menu.Type

class MenuAdapter(var mCtx: NewOrderActivity, var resources: Int, var items: List<MenuTypeView>):ArrayAdapter<MenuTypeView>(mCtx,resources,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)

        val descriptionTextView:TextView = view.findViewById(R.id.textType)

        val mItem = items[position]

        descriptionTextView.text=mItem.description

        return view
    }
}