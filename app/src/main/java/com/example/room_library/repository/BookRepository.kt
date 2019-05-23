package com.example.room_library.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.room_library.room.DAO.AutorDao
import com.example.room_library.room.DAO.BookDao
import com.example.room_library.room.DAO.EditorialDao
import com.example.room_library.room.DAO.TagDao
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag

class BookRepository(private val bookDao : BookDao, private val autorDao: AutorDao,
                     private val editorialDao : EditorialDao, private val tagDao: TagDao) {

    val allBooks : LiveData<List<Book>> = bookDao.getAllBooks()
    val allAutors : LiveData<List<Autor>> = autorDao.getAllAutors()
    val allEditoriales : LiveData<List<Editorial>> = editorialDao.getAllEdit()
    val allTags : LiveData<List<Tag>> = tagDao.getAllTags()

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

    @WorkerThread
    suspend fun insertTag(tag: Tag){
        tagDao.insert(tag)
    }

}