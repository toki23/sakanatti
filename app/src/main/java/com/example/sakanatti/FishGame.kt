package com.example.sakanatti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class FishGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_game)

        val score5: TextView = findViewById(R.id.score_game)
        var num = 185
        val score = num.toString(10)
        var text = "score:$score"
        score5.text = text


    }

}