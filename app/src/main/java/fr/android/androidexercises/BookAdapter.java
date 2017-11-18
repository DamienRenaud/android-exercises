package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by damien on 16/11/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private final List<Book> books;
    private LayoutInflater inflater;
    private final BookListFragment.OnNextListener listener;

    public BookAdapter(LayoutInflater inflater, List<Book> books, BookListFragment.OnNextListener listener) {
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
        BookItemView bookItemView = (BookItemView)holder.itemView;
        bookItemView.bindView(this.books.get(position));

        bookItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView titleBook = view.findViewById(R.id.nameTextView);
                TextView bookPrice = view.findViewById(R.id.priceTextView);
                Book book = new Book(titleBook.getText().toString(), bookPrice.getText().toString());
                for (Book b:books) {
                    if(b.getTitle().equals(titleBook.getText().toString())){
                        book = b;
                        break;
                    }
                }
                listener.onNext(book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }


    }

}