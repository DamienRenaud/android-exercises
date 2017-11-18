package fr.android.androidexercises;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by damien on 16/11/2017.
 */

interface HenriPotierService {

    @GET("books")
    Call<List<Book>> getBooks();
}
