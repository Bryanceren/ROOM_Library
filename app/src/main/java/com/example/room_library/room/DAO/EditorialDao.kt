package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial

@Dao
interface EditorialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend = corrutina
    suspend fun insert(editorial: Editorial)
    @Query("SELECT * FROM Editorial")
    fun getAllEdit(): LiveData<List<Editorial>>
}