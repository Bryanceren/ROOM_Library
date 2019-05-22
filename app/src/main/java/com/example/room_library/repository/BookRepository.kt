package com.example.room_library.repository

import androidx.lifecycle.LiveData
import com.example.room_library.room.DAO.BookDao
import com.example.room_library.room.Entities.Book

class BookRepository(private val bookDao : BookDao) {

    val allBooks : LiveData<List<Book>> = bookDao.getAllBooks()

}