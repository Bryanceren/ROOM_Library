package com.example.room_library

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class BookListadapter internal constructor(
    context: Context
) : RecyclerView.Adapter<BookListadapter.BookViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()
    private var autores= emptyList<Autor>()


    inner class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val bookitemViewimage: ImageView = itemView.findViewById(R.id.item_image)
        val bookitemViewresumen: TextView = itemView.findViewById(R.id.item_resumen)
        val bookitemViewtitle: TextView = itemView.findViewById(R.id.item_title)
        val bookitemViewautores: TextView = itemView.findViewById(R.id.item_autores)
        val bookitemViewedicion: TextView = itemView.findViewById(R.id.item_edicion)
        val bookitemViewisbn: TextView = itemView.findViewById(R.id.item_isbn)
        val bookitemViewtags: TextView = itemView.findViewById(R.id.item_tags)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        val current2= autores[position]

        Glide.with(holder.bookitemViewimage.context)
            .load(current.caratula)
            .into(holder.bookitemViewimage)

        holder.bookitemViewresumen.text = current.resumen
        holder.bookitemViewtitle.text = current.titulo
        holder.bookitemViewedicion.text = current.edicion
        holder.bookitemViewtags.text = current.tag
        holder.bookitemViewisbn.text = current.ISBN
        holder.bookitemViewautores.text = current2.nombre
    }

    internal fun setBooks(books: List<Book>){
        this.books = books
        notifyDataSetChanged()
    }

    override fun getItemCount() = books.size

}