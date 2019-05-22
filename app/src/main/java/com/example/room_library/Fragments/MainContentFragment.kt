package com.example.room_library.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room_library.R
import com.example.room_library.room.Entities.Book

/*class MainContentFragment : Fragment() {
    var book = Book

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

        view.tv_country.text=coin.country
        view.tv_isavailable.text=coin.isAvailable.toString()
        view.tv_name.text=coin.name
        view.tv_review.text=coin.review
        view.tv_value.text=coin.value.toString()
        view.tv_valueus.text=coin.value_us.toString()
        view.tv_year.text=coin.year.toString()



        //view.types_main_content_fragment.text = pokemon.types
        Glide.with(view)
            .load(coin.img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.iv_coin2)
    }
}*/
