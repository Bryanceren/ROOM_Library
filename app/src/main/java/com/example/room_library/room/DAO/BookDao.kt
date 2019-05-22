package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room_library.room.Entities.Book

@Dao
interface BookDao {

    @Insert
    //suspend = corrutina
    suspend fun insert(book: Book)


    @Query("SELECT * FROM Libro ORDER BY ASC")
    fun getALLBooks():LiveData<List<Book>>

}