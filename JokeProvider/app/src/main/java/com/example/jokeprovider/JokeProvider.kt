package com.example.jokeprovider

import android.content.*
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class JokeProvider : ContentProvider() {
    private lateinit var dbHelper: JokeDbHelper

    override fun onCreate(): Boolean {
        dbHelper = JokeDbHelper(context!!)
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(JokeContract.JokesEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder)
        cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val id: Long = db.insert(JokeContract.JokesEntry.TABLE_NAME, null, values)
        if (id != -1L) {
            context?.contentResolver?.notifyChange(uri, null)
            return ContentUris.withAppendedId(uri, id)
        }
        return null
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val count: Int = db.update(JokeContract.JokesEntry.TABLE_NAME, values, selection, selectionArgs)
        if (count > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return count
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val count: Int = db.delete(JokeContract.JokesEntry.TABLE_NAME, selection, selectionArgs)
        if (count > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return count
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            JOKES -> "vnd.android.cursor.dir/${JokeContract.AUTHORITY}.${JokeContract.PATH_JOKES}"
            JOKES_ID -> "vnd.android.cursor.item/${JokeContract.AUTHORITY}.${JokeContract.PATH_JOKES}"
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    companion object {
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(JokeContract.AUTHORITY, JokeContract.PATH_JOKES, JOKES)
            addURI(JokeContract.AUTHORITY, "${JokeContract.PATH_JOKES}/#", JOKES_ID)
        }
        const val JOKES = 100
        const val JOKES_ID = 101
    }
}
