package com.example.sakanatti

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        btn1.setOnClickListener {
            val intent = Intent(this, SubActivity0::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, FishActivity::class.java)
            startActivity(intent)
        }
    }
}
