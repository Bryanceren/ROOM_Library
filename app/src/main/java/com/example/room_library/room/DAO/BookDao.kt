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

    /*@Query("SELECT * FROM Libro where L_tag ")
    fun getBookByTag(tag: String)*/

}