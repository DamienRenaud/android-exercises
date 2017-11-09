package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private final List<Book> books;
    private LayoutInflater inflater;

    public BookAdapter(LayoutInflater inflater, List<Book> books) {
        this.books = books;
        this.inflater = inflater;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BookItemView bookItemView = (BookItemView) this.inflater.inflate(R.layout.custom_view_item_book, parent, false);
        return new MyViewHolder(bookItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((BookItemView)holder.itemView).bindView(this.books.get(position));
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    class MyViewHolder extends ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
