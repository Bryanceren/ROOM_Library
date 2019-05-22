package com.example.room_library.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.room_library.room.Entities.Editorial

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend = corrutina
    suspend fun insert(editorial: Editorial)
}