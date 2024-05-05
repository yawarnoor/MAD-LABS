package com.example.jokeprovider

import android.net.Uri
import android.provider.BaseColumns

object JokeContract {
    const val AUTHORITY = "com.example.jokeprovider"
    const val PATH_JOKES = "jokes"
    val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$PATH_JOKES")

    object JokesEntry : BaseColumns {
        const val TABLE_NAME = "jokes"
        const val COLUMN_JOKE_TEXT = "joke_text"
        const val COLUMN_JOKE_RATING = "joke_rating"
    }
}
