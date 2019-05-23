package com.example.room_library.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room_library.BookListadapter
import com.example.room_library.Models.BookViewModel
import com.example.room_library.R
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    private lateinit var bookViewModel: BookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = BookListadapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.AllBooks.observe(this, Observer { books ->
            books?.let { adapter.setBooks(it) }
        })
        val fab = findViewById<FloatingActionButton>(R.id.add)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val book = Book(
                    data.getLongExtra(NewBookActivity.EXTRA_REPLY,0),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY4),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY7),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY2),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY5),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY6)
                )
                val autor=Autor(
                    data.getLongExtra(NewBookActivity.EXTRA_REPLY,0),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY1),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY1)
                )
                val editorial=Editorial(
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY3)
                )
                bookViewModel.insertBooks(book)
                bookViewModel.insertAutors(autor)
                bookViewModel.insertEditorial(editorial)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
