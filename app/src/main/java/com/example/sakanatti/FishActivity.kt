package com.example.sakanatti

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class FishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val myView = MyView(this)
        //setContentView(myView)
        setContentView(R.layout.activity_fish)
        val btn1: Button = findViewById(R.id.id)
        val tx1: TextView = findViewById(R.id.textView)
        //val img: ImageView = findViewById(R.id.image)
        //textviewの定義↓
        val tx0:TextView = TextView(this)
        tx0.textSize = 5F
        tx0.typeface = (Typeface.DEFAULT)
        //tx0.layoutParams = LayoutParams
        //tx0.gravity =Gravity.CENTER
        fun main(args: Array<String>) {
            val randomInt = Random.nextInt(10)
        }



        btn1.setOnClickListener {

            var Score0 = Random.nextInt(5)
            when (Score0) {
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
        }

    }


}



