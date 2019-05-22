package com.example.room_library.room.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "AutorXLibro",
    primaryKeys = ["idLibro", "idAutor"],
    foreignKeys = [ForeignKey(entity = Book::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idLibro")), ForeignKey(
        entity = Autor::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idAutor")
    )]
)
data class AutorxLibro (var idAutor : Long, var idLibro : Long)