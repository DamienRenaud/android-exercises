package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Step0Fragment extends Fragment {

    private static final String step0 = "This is step 0";

    private TextView textView;
    private OnNextStep0Listener listener;

    private static final Random RANDOM = new Random();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // TODO cast context to listener
        listener = (OnNextStep0Listener)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step0, container, false);

        List<Book> books = getBooks();
        RecyclerView recyclerView = view.findViewById(R.id.bookListView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new BookAdapter(LayoutInflater.from(getContext()), books, listener));

        return view;
    }

    private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            books.add(new Book(
                    String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                    String.valueOf(RANDOM.nextInt(30)))
            );
        }
        return books;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO setText(step0)
//        ((TextView)view.findViewById(R.id.textView)).setText("Fragment 0 !");
    }

    public interface OnNextStep0Listener {

        // TODO add onNext() method
        void onNext(View view);

    }
}
