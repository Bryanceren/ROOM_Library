package com.example.room_library.Adapter

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.room_library.Activities.MainActivity
import com.example.room_library.Fragments.MainContentFragment
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
    private var editoriales= emptyList<Editorial>()
    private var tags= emptyList<Tag>()
    private lateinit var fragmentManager: FragmentManager
    private lateinit var mainContentFragment:MainContentFragment


    inner class BookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val bookitemViewTitle: TextView = itemView.findViewById(R.id.land_item_title)
        val bookitemViewautores: TextView = itemView.findViewById(R.id.land_item_autor)
        val bookitemFav: ImageButton =itemView.findViewById(R.id.land_fav)
        val wholeitem: LinearLayout =itemView.findViewById(R.id.item_landscape)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item2, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        val current2= autores[position]
        val current3= editoriales[position]
        val current4= tags[position]


        mainContentFragment = MainContentFragment.newInstance(
            Book(),
            Autor(),
            Tag(),
            Editorial()
        )

        changeFragment(R.id.land_main_cont_fragment, mainContentFragment)

        holder.wholeitem.setOnClickListener{
            mainContentFragment= MainContentFragment.newInstance(current,current2,current4,current3)
            changeFragment(R.id.land_main_cont_fragment, mainContentFragment)
        }

        //check if its a favorite adapter
        if(this.favorite==1){
            if(current.favorito==1){
                holder.bookitemViewTitle.text = current.titulo
                holder.bookitemViewautores.text = current2.nombre
            }else{
                holder.wholeitem.removeAllViewsInLayout()
                holder.wholeitem.visibility=View.GONE
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
            if(this.favorite==0) {

                if (current.favorito == 0) {
                    current.favorito = 1
                    MainActivity.bookViewModel.setFavoriteBook(current.ISBN)
                } else {
                    current.favorito = 0
                    MainActivity.bookViewModel.unsetFavoriteBook(current.ISBN)
                }
            }
        }



    }
    internal fun setFavoriteList(flag:Int){
        this.favorite = flag
        notifyDataSetChanged()
    }
    fun changeFragment(id: Int, frag: Fragment) {
        fragmentManager.beginTransaction().replace(id, frag).commit()
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
    internal fun setManager(manager: FragmentManager){
        this.fragmentManager = manager
        notifyDataSetChanged()
    }


    override fun getItemCount() = books.size

}