package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.TextView
import fr.android.androidexercises.R.id.bookListView
import java.util.*

class LibraryActivity : AppCompatActivity() {

    private val RANDOM = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        //val messageTextView = findViewById<View>(R.id.messageTextView) as TextView

        val bookListView = findViewById<View>(R.id.bookListView) as RecyclerView
        bookListView.layoutManager = GridLayoutManager(this, 1)
        bookListView.adapter = BookAdapter(
                LayoutInflater.from(this),
                getBooks()
        )

        setSupportActionBar(toolbar)
    }

    private fun getBooks(): List<Book> =
        (0..99).map {
            Book(
                    "Garry Potier Tome $it",
                    RANDOM.nextInt(30)
            )
        }
}
