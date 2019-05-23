package com.example.room_library.room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room_library.room.DAO.AutorDao
import com.example.room_library.room.DAO.BookDao
import com.example.room_library.room.DAO.EditorialDao
import com.example.room_library.room.DAO.TagDao
import com.example.room_library.room.Entities.Autor
import com.example.room_library.room.Entities.Book
import com.example.room_library.room.Entities.Editorial
import com.example.room_library.room.Entities.Tag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Autor::class, Book::class ,Editorial::class, Tag::class], version = 3, exportSchema = false)
public abstract class LibraryDB: RoomDatabase(){

    abstract fun autorDao():AutorDao
    abstract fun bookDao(): BookDao
    abstract fun editorialDao() : EditorialDao
    abstract fun tagDao() : TagDao
    //Todos los DAO

    companion object {
        @Volatile
        private var INSTANCE:LibraryDB? = null

        fun getInstance(Appcontext: Context): LibraryDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(Appcontext,LibraryDB::class.java,"Library_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

}