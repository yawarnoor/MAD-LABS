package com.example.jokeprovider

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var jokeInput: EditText
    private lateinit var ratingInput: EditText
    private lateinit var submitButton: Button
    private lateinit var loadJokesButton: Button
    private lateinit var jokesDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeInput = findViewById(R.id.joke_input)
        ratingInput = findViewById(R.id.rating_input)
        submitButton = findViewById(R.id.submit_button)
        loadJokesButton = findViewById(R.id.load_jokes_button)
        jokesDisplay = findViewById(R.id.jokes_display)

        submitButton.setOnClickListener {
            insertJoke()
        }

        loadJokesButton.setOnClickListener {
            loadJokes()
        }
    }

    private fun insertJoke() {
        val jokeText = jokeInput.text.toString()
        val rating = ratingInput.text.toString().toIntOrNull() ?: 0
        val values = ContentValues().apply {
            put(JokeContract.JokesEntry.COLUMN_JOKE_TEXT, jokeText)
            put(JokeContract.JokesEntry.COLUMN_JOKE_RATING, rating)
        }

        val uri = contentResolver.insert(JokeContract.CONTENT_URI, values)
        if (uri != null) {
            Toast.makeText(this, "Joke added successfully!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error adding joke", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    private fun loadJokes() {
        val cursor = contentResolver.query(
            JokeContract.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.let {
            val stringBuilder = StringBuilder()
            while (it.moveToNext()) {
                val joke = it.getString(it.getColumnIndex(JokeContract.JokesEntry.COLUMN_JOKE_TEXT))
                val rating = it.getInt(it.getColumnIndex(JokeContract.JokesEntry.COLUMN_JOKE_RATING))
                stringBuilder.append("$joke - Rating: $rating\n")
            }
            jokesDisplay.text = stringBuilder.toString()
            it.close()
        }
    }
}
