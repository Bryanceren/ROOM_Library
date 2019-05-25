package com.example.room_library.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
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
    private var favorite=0
    private var books = emptyList<Book>()
    private var autores= emptyList<Autor>()


    inner class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val bookitemViewTitle: TextView = itemView.findViewById(R.id.land_item_title)
        val bookitemViewautores: TextView = itemView.findViewById(R.id.land_item_autor)
        val bookitemFav: ImageButton =itemView.findViewById(R.id.land_fav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item2, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        val current2= autores[position]
        //check if its a favorite adapter
        if(this.favorite==1){
            if(current.favorito==1){
                holder.bookitemViewTitle.text = current.titulo
                holder.bookitemViewautores.text = current2.nombre
            }
        }
        else{
            holder.bookitemViewTitle.text = current.titulo
            holder.bookitemViewautores.text = current2.nombre
        }

        //check favorite item
        if(current.favorito==0){
            holder.bookitemFav.setImageResource(R.drawable.ic_favorite_border_black_24dp)
        }
        else{
            holder.bookitemFav.setImageResource(R.drawable.ic_favorite_black_24dp)
        }
        //click listener for each favorite button
        holder.bookitemFav.setOnClickListener {
            if(current.favorito==0){
                current.favorito=1
                holder.bookitemFav.setImageResource(R.drawable.ic_favorite_black_24dp)
                /*listenerTools?.managePortraitItemClick(current)*/
                MainActivity.bookViewModel.setFavoriteBook(current.ISBN)
            }else{
                current.favorito=0
                holder.bookitemFav.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                /*listenerTools?.managePortraitItemClick(current)*/
                MainActivity.bookViewModel.unsetFavoriteBook(current.ISBN)

            }
        }



    }
    internal fun setFavoriteList(flag:Int){
        this.favorite = flag
        notifyDataSetChanged()
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