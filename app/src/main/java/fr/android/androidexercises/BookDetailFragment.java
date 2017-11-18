package fr.android.androidexercises;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class BookDetailFragment extends Fragment {

    // TODO Override onCreateViewMethod


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        Book book = getArguments().getParcelable("book");

        TextView textView = view.findViewById(R.id.step1TextView);
        ImageView bookCover = view.findViewById(R.id.bookCover);

        Glide.with(this).load(book.getCover()).into(bookCover);


        textView.setText(book.getSynopsis().get(0));
        return view;
    }

}
