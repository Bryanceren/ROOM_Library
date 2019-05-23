package com.example.room_library.Activities

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.room_library.R

/**
 * Activity for entering a word.
 */

class NewBookActivity : AppCompatActivity() {

    private lateinit var editTitleView: EditText
    private lateinit var editAutorView: EditText
    private lateinit var editEdicionView: EditText
    private lateinit var editEditorialView: EditText
    private lateinit var editISBNView: EditText
    private lateinit var editResumenView: EditText
    private lateinit var editTagsView: EditText
    private lateinit var editCaratulaView: EditText


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)
        editTitleView = findViewById(R.id.edit_title)
        editAutorView = findViewById(R.id.edit_autor)
        editEdicionView = findViewById(R.id.edit_edicion)
        editEditorialView = findViewById(R.id.edit_editorial)
        editISBNView = findViewById(R.id.edit_isbn)
        editResumenView = findViewById(R.id.edit_resumen)
        editTagsView = findViewById(R.id.edit_tags)
        editCaratulaView = findViewById(R.id.edit_caratula)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTitleView.text) ||
                TextUtils.isEmpty(editAutorView.text) ||
                TextUtils.isEmpty(editEdicionView.text) ||
                TextUtils.isEmpty(editEditorialView.text) ||
                TextUtils.isEmpty(editISBNView.text) ||
                TextUtils.isEmpty(editResumenView.text) ||
                TextUtils.isEmpty(editTagsView.text) ||
                TextUtils.isEmpty(editCaratulaView.text)
                    ) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = editTitleView.text.toString()
                val autor = editAutorView.text.toString()
                val edicion = editEdicionView.text.toString()
                val editorial = editEditorialView.text.toString()
                val isbn = editISBNView.text.toString()
                val resumen = editResumenView.text.toString()
                val tags = editTagsView.text.toString()
                val caratula = editCaratulaView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, title)
                replyIntent.putExtra(EXTRA_REPLY1, autor)
                replyIntent.putExtra(EXTRA_REPLY2, edicion)
                replyIntent.putExtra(EXTRA_REPLY3, editorial)
                replyIntent.putExtra(EXTRA_REPLY4, isbn)
                replyIntent.putExtra(EXTRA_REPLY5, resumen)
                replyIntent.putExtra(EXTRA_REPLY6, tags)
                replyIntent.putExtra(EXTRA_REPLY7, caratula)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.booklistsql.REPLY"
        const val EXTRA_REPLY1 = "com.example.android.booklistsql.REPLY1"
        const val EXTRA_REPLY2 = "com.example.android.booklistsql.REPLY2"
        const val EXTRA_REPLY3 = "com.example.android.booklistsql.REPLY3"
        const val EXTRA_REPLY4 = "com.example.android.booklistsql.REPLY4"
        const val EXTRA_REPLY5 = "com.example.android.booklistsql.REPLY5"
        const val EXTRA_REPLY6 = "com.example.android.booklistsql.REPLY6"
        const val EXTRA_REPLY7 = "com.example.android.booklistsql.REPLY7"
    }
}

