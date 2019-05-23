package com.example.room_library.Models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room_library.repository.BookRepository
import com.example.room_library.room.Database.LibraryDB
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel (app: Application): AndroidViewModel(app){
    private val repository : BookRepository
    val allBooks : LiveData<List<Book>>
    val allAutors : LiveData<List<Autor>>
    val allEditoriales : LiveData<List<Editorial>>
    val allTags : LiveData<List<Tag>>


    init {
        val bookDao = LibraryDB.getInstance(app).bookDao()
        val autorDao = LibraryDB.getInstance(app).autorDao()
        val ediDao = LibraryDB.getInstance(app).editorialDao()
        val tagDao = LibraryDB.getInstance(app).tagDao()
        repository = BookRepository(bookDao, autorDao, ediDao, tagDao)
        allBooks = repository.allBooks
        allAutors = repository.allAutors
        allEditoriales = repository.allEditoriales
        allTags = repository.allTags
    }

    fun insertBooks (book: Book) = viewModelScope.launch(Dispatchers.IO){
        repository.insertBook(book)
    }

    fun insertAutors (autor: Autor) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertAutor(autor)
    }

    fun insertEditorial (editorial: Editorial) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertEditorial(editorial)
    }

    fun insertTag (tag: Tag) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTag(tag)
    }
}