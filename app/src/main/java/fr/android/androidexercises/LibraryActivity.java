package fr.android.androidexercises;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.android.androidexercises.fragments.BookDetailFragment;
import fr.android.androidexercises.fragments.BookListFragment;
import fr.android.androidexercises.model.Book;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity implements BookListFragment.OnNextListener {

    private Book selectedBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Timber.plant(new Timber.DebugTree());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new BookListFragment(), BookListFragment.class.getSimpleName())
                .commit();

        if(savedInstanceState != null) {
            Book book = savedInstanceState.getParcelable("book");
            if(book != null) {
                onNext(book);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        if(this.selectedBook != null) {
            savedInstanceState.putParcelable("book", this.selectedBook);
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onNext(Book book) {
        this.selectedBook = book;
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        bookDetailFragment.setArguments(bundle);

        if(Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bookDetailFrameLayout, bookDetailFragment, BookDetailFragment.class.getSimpleName())
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containerFrameLayout, bookDetailFragment, BookDetailFragment.class.getSimpleName())
                    .addToBackStack("step1")
                    .commit();
        }
    }

}
