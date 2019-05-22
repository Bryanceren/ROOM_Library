package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
@ForeignKey(
    entity = Tag::class,
    parentColumns = ["id"],
    childColumns = ["tags"],
    onDelete = CASCADE
)

class Book(
    @PrimaryKey var ISBN : String,
    @ColumnInfo(name = "L_caratula")var caratula : String,
    @ColumnInfo(name = "L_titulo") var titulo : String,
    @ColumnInfo(name = "L_edicion") var edicion : String,
    @ColumnInfo(name = "L_resumen") var resumen : String,
    @ColumnInfo(name = "L_tag") var tags : String
)