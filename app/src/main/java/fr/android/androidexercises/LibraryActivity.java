package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // TODO Get image view and load image form URL
        // http://img3.wikia.nocookie.net/__cb20120317101541/harrypotter/images/3/37/Gryffindor_Crest.jpg
        ImageView dImageView = (ImageView) findViewById(R.id.downloadImageView);
        ImageView lImageView = (ImageView) findViewById(R.id.localImageView);

        Glide.with(this).load("http://img3.wikia.nocookie.net/__cb20120317101541/harrypotter/images/3/37/Gryffindor_Crest.jpg").into(dImageView);
        Glide.with(this).load("mipmap-hdpi/ic_launcher.png").into(lImageView);
    }

}
