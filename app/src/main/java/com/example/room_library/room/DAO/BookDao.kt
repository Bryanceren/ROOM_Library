package com.example.room_library.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.room_library.room.Entities.Book

@Dao
interface BookDao {

    @Insert
    //suspend = corrutina
    suspend fun insert(book: Book)

}