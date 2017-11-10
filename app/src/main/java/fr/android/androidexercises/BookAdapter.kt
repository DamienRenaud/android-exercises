package fr.android.androidexercises

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by damien on 10/11/2017.
 */

class BookAdapter(val layoutInflater: LayoutInflater, val books: List<Book>) : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {



    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        (holder?.itemView as BookItemView).bindView((this.books.get(position)))
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        val bookItemView = this.layoutInflater.inflate(R.layout.custom_view_item_book, parent, false)
        return MyViewHolder(bookItemView)
    }


    class MyViewHolder(itemView : View?) : ViewHolder(itemView)
}
