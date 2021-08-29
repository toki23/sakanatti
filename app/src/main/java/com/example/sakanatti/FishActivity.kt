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

        fun main(args: Array<String>) {
            val randomInt = Random.nextInt(10)

            println(randomInt)
        }
        btn1.setOnClickListener {
            //val intent = Intent(this,{}::class.java)
            //startActivity(intent)

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

    inner class MyView(context: Context) : View(context) {
        private var paint: Paint = Paint()

        // 描画するラインの太さ
        //private val lineStrokeWidth = 20f
    
        init {
        }

        //
        override fun onDraw(canvas: Canvas) {


            val fish = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
            //val sb = BitmapFactory.decodeResource(resources, R.drawable.speechballoon)
            val dst = Rect(width / 2, height / 2, +width / 2 + 500, height / 2 + 400)
            //val dst1 =Rect(width / 2 - 350, height / 2 - 150, +width / 2 + 100, height / 2 + 180)
            val src = null
            canvas.drawBitmap(fish, src, dst, paint)
            //canvas.drawBitmap(sb, src, dst1, paint)

        }

    }
    }





