package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tag")
data class Tag (
    @ColumnInfo(name = "T_tag") var Tag : String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}