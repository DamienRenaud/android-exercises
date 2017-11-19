package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class BookListFragment extends Fragment {

    private static final String step0 = "This is step 0";

    private OnNextListener listener;
    private RecyclerView recyclerView;
    private LayoutInflater layoutInflater;
    private View root;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // TODO cast context to listener
        listener = (OnNextListener)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_book_list, container, false);
        recyclerView = root.findViewById(R.id.bookListView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new BookAdapter(LayoutInflater.from(BookListFragment.this.getContext()), listener));

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        service.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                List<Book> books = response.body();

                for(Book b: books) {
                    Timber.d(b.getTitle());
                }
                
                ((BookAdapter) recyclerView.getAdapter()).setBooks(books);

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t);
            }
        });


    }

    public interface OnNextListener {

        // TODO add onNext() method
        void onNext(Book book);

    }
}
