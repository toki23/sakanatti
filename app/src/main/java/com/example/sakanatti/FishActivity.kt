package com.example.sakanatti

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class FishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)
        var count: Int = 0
        val btn1: Button = findViewById(R.id.id)
        val tx1: TextView = findViewById(R.id.textView)
        val data = Database.select(applicationContext)
        var score0 = data[0]
        var score1 = data[1]
        var score2 = data[2]
        var score3 = data[3]
        btn1.setOnClickListener {
            count++

            //textView.text = "${count}"
            when (count) {
             1 -> when (score0) {
               1 -> {
                   tx1.text = "床がかなり散らかっています。"
               }
               2 -> {
                   tx1.text = "床が散らかっています。"
               }
               3 -> {
                   tx1.text = "床を掃除しよう。"
               }
               4 -> {
                   tx1.text = "床を確認しよう。"
               }
               5 -> {
                   tx1.text = "床はきれいですね。"
               }
                }
             2 -> when (score1) {//1
               1 -> {
                   tx1.text = "机の上がかなり散らかっています。"
               }
               2 -> {
                   tx1.text = "机が散らかっています。"
               }
               3 -> {
                   tx1.text = "机を掃除しよう。"
               }
               4 -> {
                   tx1.text = "机を確認しよう。"
               }
               5 -> {
                   tx1.text = "机はきれいですね。"
               }
               }
            3  -> when (score2) {//2
               1 -> {
                   tx1.text = "本がかなり散らかっています。"
               }
               2 -> {
                   tx1.text = "本が散らかっています。"
               }
               3 -> {
                   tx1.text = "本を掃除しよう。"
               }
               4 -> {
                   tx1.text = "本を確認しよう。"
               }
               5 -> {
                   tx1.text = "本はきれいですね。"
               }
            }
           4 -> when (score3) {//3
               1 -> {
                   tx1.text = "服がかなり散らかっています。"
               }
               2 -> {
                   tx1.text = "服が散らかっています。"
               }
               3 -> {
                   tx1.text = "服を掃除しよう。"
               }
               4 -> {
                   tx1.text = "服を確認しよう。"
               }
               5 -> {
                   tx1.text = "服はきれいですね。"
               }


               }
            }
        }
    }
}



