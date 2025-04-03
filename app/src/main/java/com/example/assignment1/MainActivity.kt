package com.example.assignment1

import .github/workflows/main.ymlandroid.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Here i have declared the variables
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        //Author: OpenAichatgpt
        //url:https://chatgpt.com/g/g-G7TYuJJCE-gpt-plus/c/67ed123b-1cc8-800e-8740-09aff07b3f3e

        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "A healthy breakfast like eggs with toast!"
                "mid-morning" -> "Time for a light snack such as fruit or a protein bar."
                "afternoon" -> "A chicken and lettuce sandwich with a fruit juice to provide energy."
                "mid-afternoon" -> "have some herbal tea or coffee of your choice!"
                "dinner" -> "Enjoy a nice meal containing a protein such as chicken or meat and veg."
                else -> "Please enter a valid time of day."
            }
            textViewSuggestion.text = suggestion
            buttonReset.setOnClickListener {
                editTextTime.text.clear()
                textViewSuggestion.text = ""
            }

    }
}