package com.example.room_library.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.room_library.R
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag
import kotlinx.android.synthetic.main.fragment_main_details.view.*

class MainContentFragment : Fragment() {
    var book = Book()
    var autor = Autor()
    var tag = Tag()
    var edit = Editorial()

    companion object {
        fun newInstance(book: Book): MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.book = book
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main_details, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){

        view.autor_main_content_fragment.text = autor.nombre
        view.isbn_main_content_fragment.text = book.ISBN
        view.edicion_main_content_fragment.text = book.edicion
        view.tags_main_content_fragment.text = tag.Tag
        view.editorial_main_content_fragment.text = edit.name
        view.resumen_main_content_fragment.text = book.resumen


        Glide.with(view)
            .load(book.caratula)
            .into(view.image_main_content_fragment)
            /*
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.image_main_content_fragment)*/
    }
}
