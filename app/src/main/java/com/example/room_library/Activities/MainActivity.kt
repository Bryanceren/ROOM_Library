package com.example.room_library.Activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room_library.Adapter.BookListadapter
import com.example.room_library.Adapter.BookListadapterLand
import com.example.room_library.Models.BookViewModel
import com.example.room_library.R
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    companion object{
        lateinit var bookViewModel: BookViewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter2=BookListadapterLand(this)
        val adapter = BookListadapter(this)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }

        else{
            val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerview2)
            recyclerView2.adapter = adapter2
            recyclerView2.layoutManager = LinearLayoutManager(this)

        }



        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.allBooks.observe(this, Observer { books ->
            books?.let { adapter.setBooks(it) }
        })
        bookViewModel.allEditoriales.observe(this, Observer { editoriales ->
            editoriales?.let { adapter.setEditoriales(it) }
        })
        bookViewModel.allAutors.observe(this, Observer { books ->
            books?.let { adapter.setAutores(it) }
        })
        bookViewModel.allTags.observe(this, Observer { books ->
            books?.let { adapter.setTags(it) }
        })
        bookViewModel.allBooks.observe(this, Observer { books ->
            books?.let { adapter2.setBooks(it) }
        })
        bookViewModel.allAutors.observe(this, Observer { books ->
            books?.let { adapter2.setAutores(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.add)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
        var favFlag = 0
        val fav= findViewById<FloatingActionButton>(R.id.favs)
        fav.setOnClickListener{
            if (favFlag==0){
                fav.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                favFlag=1
            }else{
                fav.setImageResource(R.drawable.ic_favorite_black_24dp)
                favFlag=0
            }

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
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY5)

                )
                val autor=Autor(
                    data.getLongExtra(NewBookActivity.EXTRA_REPLY,0),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY1),
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY1)
                )
                val editorial=Editorial(
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY3)
                )
                val tag=Tag(
                    data.getStringExtra(NewBookActivity.EXTRA_REPLY6)
                )
                bookViewModel.insertBooks(book)
                bookViewModel.insertAutors(autor)
                bookViewModel.insertEditorial(editorial)
                bookViewModel.insertTag(tag)
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
