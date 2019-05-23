package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room_library.room.Entities.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend = corrutina
    suspend fun insert(book: Book)


    @Query("SELECT * FROM Libro")
    fun getAllBooks():LiveData<List<Book>>

    @Query("UPDATE Libro SET L_Favorito = 1 WHERE L_isbn = (:ISBN)")
    fun setFavoriteBook(ISBN: String)

    @Query("SELECT * FROM Libro WHERE Libro.L_Favorito = 1")
    fun getFavoriteBooks(): LiveData<List<Book>>



}