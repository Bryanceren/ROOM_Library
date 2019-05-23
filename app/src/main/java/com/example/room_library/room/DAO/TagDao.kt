package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tag: Tag)
    @Query("SELECT * FROM Tag")
    fun getAllTags(): LiveData<List<Tag>>
}