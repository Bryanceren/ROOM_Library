package com.example.room_library.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.room_library.Activities.MainActivity
import com.example.room_library.R
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookListadapterLand internal constructor(
    context: Context
) : RecyclerView.Adapter<BookListadapterLand.BookViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()
    private var autores= emptyList<Autor>()

    inner class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val bookitemViewTitle: TextView = itemView.findViewById(R.id.land_item_title)
        val bookitemViewautores: TextView = itemView.findViewById(R.id.land_item_autor)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item2, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        val current2= autores[position]

        holder.bookitemViewTitle.text = current.titulo
        holder.bookitemViewautores.text = current2.nombre


    }

    internal fun setBooks(books: List<Book>){
        this.books = books
        notifyDataSetChanged()
    }
    internal fun setAutores(autores: List<Autor>){
        this.autores = autores
        notifyDataSetChanged()
    }


    override fun getItemCount() = books.size

}