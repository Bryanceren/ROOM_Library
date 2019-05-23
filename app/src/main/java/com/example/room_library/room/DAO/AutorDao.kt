package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book

@Dao
interface AutorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend = corrutina
    suspend fun insert(autor : Autor)

    @Query("SELECT * FROM Autor")
    fun getAllAutors(): LiveData<List<Autor>>
}