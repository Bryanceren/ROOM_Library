package com.example.room_library.room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
data class Autor(
    @PrimaryKey(autoGenerate = true)
    var id:Long =0,
    @ColumnInfo(name = "A_nombre") var nombre : String,
    @ColumnInfo(name = "A_apellido") var apellido : String
)