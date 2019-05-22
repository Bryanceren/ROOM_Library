package com.example.room_library.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.room_library.room.Entities.Autor

@Dao
interface AutorDao {

    @Insert
    //suspend = corrutina
    suspend fun insert(autor: Autor)

}