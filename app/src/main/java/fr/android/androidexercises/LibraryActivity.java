package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());
        Timber.log(1, "Book : ");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        service.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> list = response.body();
                for(Book book : list) {
                    Timber.log(1, "Book : ", book);
                    Log.i("Book", book.getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });

        // TODO replace Step0Fragment in containerFrameLayout

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                .commit();
        //View viewById = findViewById(R.id.containerFrameLayout);
    }



    @Override
    public void onNext(View view) {
        // TODO replace Step1Fragment in containerFrameLayout
        Step1Fragment step1Fragment = new Step1Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("viewId", view.getId());
        step1Fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, step1Fragment, Step1Fragment.class.getSimpleName())
                .addToBackStack("step1")
                .commit();
    }

}
