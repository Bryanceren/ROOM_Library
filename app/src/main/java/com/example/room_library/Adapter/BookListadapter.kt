package com.example.room_library.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class BookListadapter internal constructor(
    context: Context
) : RecyclerView.Adapter<BookListadapter.BookViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()
    private var autores= emptyList<Autor>()
    private var editoriales= emptyList<Editorial>()
    private var tags= emptyList<Tag>()


    inner class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val bookitemViewimage: ImageView = itemView.findViewById(R.id.item_image)
        val bookitemViewresumen: TextView = itemView.findViewById(R.id.item_resumen)
        val bookitemViewtitle: TextView = itemView.findViewById(R.id.item_title)
        val bookitemVieweditorial: TextView = itemView.findViewById(R.id.item_editorial)
        val bookitemViewautores: TextView = itemView.findViewById(R.id.item_autores)
        val bookitemViewedicion: TextView = itemView.findViewById(R.id.item_edicion)
        val bookitemViewisbn: TextView = itemView.findViewById(R.id.item_isbn)
        val bookitemViewtags: TextView = itemView.findViewById(R.id.item_tags)
        val bookitemFav:ImageButton=itemView.findViewById(R.id.fav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        val current2= autores[position]
        val current3= editoriales[position]
        val current4= tags[position]

        if(current.favorito==0){
            holder.bookitemFav.setImageResource(R.drawable.ic_favorite_border_black_24dp)
        }
        else{
            holder.bookitemFav.setImageResource(R.drawable.ic_favorite_black_24dp)
        }

        holder.bookitemFav.setOnClickListener {
            if(current.favorito==0){
                current.favorito=1
                holder.bookitemFav.setImageResource(R.drawable.ic_favorite_black_24dp)
            }else{
                current.favorito=0
                holder.bookitemFav.setImageResource(R.drawable.ic_favorite_border_black_24dp)

            }
        }


        Glide.with(holder.bookitemViewresumen.context)
            .load(current.caratula)
            .into(holder.bookitemViewimage)
        holder.bookitemViewresumen.text = current.resumen
        holder.bookitemViewtitle.text = current.titulo
        holder.bookitemViewedicion.text = current.edicion
        holder.bookitemViewtags.text = current4.Tag
        holder.bookitemViewisbn.text = current.ISBN
        holder.bookitemViewautores.text = current2.nombre
        holder.bookitemVieweditorial.text=current3.name
    }

    internal fun setBooks(books: List<Book>){
        this.books = books
        notifyDataSetChanged()
    }
    internal fun setAutores(autores: List<Autor>){
        this.autores = autores
        notifyDataSetChanged()
    }
    internal fun setEditoriales(editoriales: List<Editorial>){
        this.editoriales = editoriales
        notifyDataSetChanged()
    }
    internal fun setTags(tags: List<Tag>){
        this.tags = tags
        notifyDataSetChanged()
    }

    fun changeFav(book: Book){

    }

    override fun getItemCount() = books.size

}