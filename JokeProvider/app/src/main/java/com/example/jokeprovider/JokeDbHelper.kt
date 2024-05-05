package com.example.jokeprovider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class JokeDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "jokes.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_JOKES_TABLE = """
            CREATE TABLE ${JokeContract.JokesEntry.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${JokeContract.JokesEntry.COLUMN_JOKE_TEXT} TEXT NOT NULL,
                ${JokeContract.JokesEntry.COLUMN_JOKE_RATING} INTEGER NOT NULL
            );
        """.trimIndent()

        db.execSQL(SQL_CREATE_JOKES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${JokeContract.JokesEntry.TABLE_NAME}")
        onCreate(db)
    }
}
