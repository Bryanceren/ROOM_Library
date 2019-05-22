package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tag")
class Tag (
    @PrimaryKey(autoGenerate = true) var id : Long,
    @ColumnInfo(name = "tag") var tag : String
)