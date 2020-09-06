package com.mugh.creditsocibar.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mugh.creditsocibar.MainActivity
import com.mugh.creditsocibar.R

import com.mugh.creditsocibar.entities.ArticleView

class MyAdapter(var mCtx: MainActivity, var resources: Int, var items: List<ArticleView>):ArrayAdapter<ArticleView>(mCtx,resources,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)

        val imageView:ImageView = view.findViewById(R.id.image)
        val titleTextView:TextView = view.findViewById(R.id.textView1)
        val descriptionTextView:TextView = view.findViewById(R.id.textView2)

        var mItem:ArticleView = items[position]
        imageView.setImageDrawable(mItem.logo?.let { mCtx.resources.getDrawable(it) })
        titleTextView.text = mItem.description
        descriptionTextView.text = mItem.import.toString()+"€"

        return view
    }
}