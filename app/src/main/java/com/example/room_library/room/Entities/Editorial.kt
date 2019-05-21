package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Editorial")
data class Editorial (
    @ColumnInfo(name = "E_name") var name : String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}
