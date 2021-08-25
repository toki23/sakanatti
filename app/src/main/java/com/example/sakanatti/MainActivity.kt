package com.example.sakanatti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1:Button= findViewById(R.id.btn1)
        val btn2:Button = findViewById(R.id.btn2)
        btn1.setOnClickListener{
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this,FishActivity::class.java)
            startActivity(intent)
        }
    }
}
