package com.example.room_library.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.room_library.room.Entities.Editorial

@Dao
interface EditorialDao {

    @Insert
    //suspend = corrutina
    suspend fun insert(editorial: Editorial)

}