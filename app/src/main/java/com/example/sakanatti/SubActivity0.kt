package com.example.sakanatti

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub0)
        val tx1: TextView = findViewById(R.id.tx_Unrated)
        val bt0: Button = findViewById(R.id.bt_evaluate)
        bt0.setOnClickListener {
            tx1.text = "評価済み"

            val intent = Intent(this, Evaluation::class.java)
            startActivity(intent)

            bt0.setEnabled(false)
        }
    }
}