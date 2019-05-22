package com.example.room_library.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.room_library.room.DAO.AutorDao
import com.example.room_library.room.DAO.BookDao
import com.example.room_library.room.DAO.EditorialDao
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial

class BookRepository(private val bookDao : BookDao, private val autorDao: AutorDao,
                     private val editorialDao : EditorialDao) {

    val allBooks : LiveData<List<Book>> = bookDao.getAllBooks()

    @WorkerThread
    suspend fun insertBook(book: Book){
        bookDao.insert(book)
    }

    @WorkerThread
    suspend fun insertAutor(autor: Autor){
        autorDao.insert(autor)
    }

    @WorkerThread
    suspend fun insertEditorial(editorial: Editorial){
        editorialDao.insert(editorial)
    }

}