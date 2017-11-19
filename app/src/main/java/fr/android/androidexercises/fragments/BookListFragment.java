package fr.android.androidexercises.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;
import fr.android.androidexercises.model.BookAdapter;
import fr.android.androidexercises.services.HenriPotierService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class BookListFragment extends Fragment{

    private OnNextListener listener;
    private RecyclerView recyclerView;
    private View root;
    private HenriPotierService service;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnNextListener)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_book_list, container, false);
        recyclerView = root.findViewById(R.id.bookListView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(new BookAdapter(LayoutInflater.from(BookListFragment.this.getContext()), listener));
        initHenriPotierService();
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callBookService();
    }

    public void initHenriPotierService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(HenriPotierService.class);
    }

    public void callBookService() {
        service.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> books = response.body();
                ((BookAdapter) recyclerView.getAdapter()).setBooks(books);

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    public interface OnNextListener {
        void onNext(Book book);

    }
}
