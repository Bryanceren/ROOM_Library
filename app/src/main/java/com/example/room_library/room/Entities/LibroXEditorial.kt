package com.example.room_library.room.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "LibroXEditorial",
    primaryKeys = ["idLibro", "idEditorial"],
    foreignKeys = [
        ForeignKey(
            entity = Book::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("idLibro")),
        ForeignKey(
            entity = Editorial::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("idEditorial")
        )
    ])
data class LibroXEditorial (var idLibro: Long, var idEditorial : Long)