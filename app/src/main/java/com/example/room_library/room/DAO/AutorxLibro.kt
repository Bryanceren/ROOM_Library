package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.room_library.room.Entities.Book

@Dao
interface AutorxLibro {

    @Query("SELECT * FROM Libro INNER JOIN AutorXLibro INNER JOIN Autor " +
            "WHERE Libro.id = AutorXLibro.idLibro AND Autor.id = AutorXLibro.idAutor")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM Libro INNER JOIN AutorXLibro INNER JOIN Autor " +
            "WHERE Libro.id = AutorXLibro.idLibro AND Autor.A_nombre = (:autor)")
    fun getBooksbyAutor(autor : String): LiveData<List<Book>>


}