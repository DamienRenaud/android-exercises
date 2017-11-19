package fr.android.androidexercises;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity implements BookListFragment.OnNextListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());
        Timber.log(1, "Book : ");




        // TODO replace BookListFragment in containerFrameLayout

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new BookListFragment(), BookListFragment.class.getSimpleName())
                .commit();
    }



    @Override
    public void onNext(Book book) {
        // TODO replace BookDetailFragment in containerFrameLayout
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        Timber.d(book.getTitle());
        bookDetailFragment.setArguments(bundle);

        if(Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bookDetailFrameLayout, bookDetailFragment, BookDetailFragment.class.getSimpleName())
//                    .addToBackStack("step1")
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
