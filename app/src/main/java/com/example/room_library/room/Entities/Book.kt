package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
class Book(
    @PrimaryKey var ISBN : String,
    @ColumnInfo(name = "L_caratula")var caratula : String,
    @ColumnInfo(name = "L_titulo") var titulo : String,
    @ColumnInfo(name = "L_edicion") var edicion : String,
    @ColumnInfo(name = "L_resumen") var resumen : String
)