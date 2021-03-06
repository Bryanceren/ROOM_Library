package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
data class Book(
    @PrimaryKey(autoGenerate = true) var id :Long,
    @ColumnInfo(name = "L_isbn") var ISBN : String,
    @ColumnInfo(name = "L_caratula")var caratula : String,
    @ColumnInfo(name = "L_titulo") var titulo : String,
    @ColumnInfo(name = "L_edicion") var edicion : String,
    @ColumnInfo(name = "L_resumen") var resumen : String,
    @ColumnInfo(name = "L_Favorito") var favorito : Int = 0

){
    constructor():
            this(0, "","","","","",0)
}
