package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tag")
data class Tag (
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "T_tag") var Tag : String
){

    constructor():
            this(0, "")

}