package com.example.wineapplication.ui.TypeOfWine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.wineapplication.R
import com.raywenderlich.android.alltherecipes.TypeOfWine
import com.squareup.picasso.Picasso

class TypeOfWineAdapter(private val context: Context, private val dataSource: ArrayList<TypeOfWine>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = LayoutInflater.from(context)


    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_wine, parent, false)
        // Get title element
        val titleTextView = rowView.findViewById(R.id.recipe_list_title) as TextView

        // Get subtitle element
        val subtitleTextView = rowView.findViewById(R.id.recipe_list_subtitle) as TextView

        // Get detail element
        val detailTextView = rowView.findViewById(R.id.recipe_list_detail) as TextView

        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.recipe_list_thumbnail) as ImageView

        val wine = getItem(position) as TypeOfWine

        // 2
        titleTextView.text = wine.title
        subtitleTextView.text = wine.description
        detailTextView.text = wine.price

        // 3

        Picasso.get().load(wine.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)
        return rowView
    }
}