package com.example.room_library.room.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Editorial")
data class Editorial (
    @PrimaryKey var name : String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}
