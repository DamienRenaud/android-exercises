package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by damien on 16/11/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private final List<Book> books;
    private LayoutInflater inflater;
    private final Step0Fragment.OnNextStep0Listener listener;

    public BookAdapter(LayoutInflater inflater, List<Book> books, Step0Fragment.OnNextStep0Listener listener) {
        this.books = books;
        this.inflater = inflater;
        this.listener = listener;
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onNext(view);
                }
            });
        }


    }

}