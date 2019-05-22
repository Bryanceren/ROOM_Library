package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
class Autor (
    @PrimaryKey(autoGenerate = true) var id : Long,
    @ColumnInfo(name = "Nombre") var nombre : String,
    @ColumnInfo(name = "Apellido") var apellido : String
)