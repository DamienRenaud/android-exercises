package fr.android.androidexercises.services;

import java.util.List;

import fr.android.androidexercises.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by damien on 16/11/2017.
 */

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> getBooks();
}
