package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Editorial")
class Editorial(
    @PrimaryKey(autoGenerate = true) var id : Long,
    @ColumnInfo(name = "nombre") var nombre : String
)