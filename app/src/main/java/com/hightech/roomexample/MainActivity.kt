package com.hightech.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordViewModel.allWords.observe(this) { words ->
            Log.d("TAG", words.toString())
        }

        val buttonInsertData = findViewById<Button>(R.id.buttonInsertData)
        buttonInsertData.setOnClickListener {
            val word = Word("Fiqri Hafzain")
            wordViewModel.insert(word)
            Log.d("TAG", "Insert data success !")
        }
    }
}