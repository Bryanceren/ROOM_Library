package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.room_library.room.Entities.Book

@Dao
interface LibroXEditorial {
    @Query("SELECT * FROM Libro INNER JOIN LibroXEditorial INNER JOIN Editorial " +
            "WHERE Libro.id = LibroXEditorial.idLibro AND Editorial.id = LibroXEditorial.idEditorial")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM Libro INNER JOIN LibroXEditorial INNER JOIN Editorial " +
            "WHERE Libro.id = LibroXEditorial.idLibro AND Editorial.E_name = (:editorial)")
    fun getBooksbyAutor(editorial : String): LiveData<List<Book>>

}