package com.example.sakanatti

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class FishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myView = MyView(this)
        setContentView(myView)
    }
    internal inner class MyView(context: Context) : View(context) {
        private var paint: Paint = Paint()
        // 描画するラインの太さ
        private val lineStrokeWidth = 20f

        init {
        }

        override fun onDraw(canvas: Canvas){


            val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
            val dst = Rect(canvas.width/2, canvas.height/2,  + canvas.width/2 + 500,canvas.height/2 + 400)

            val src = null
            canvas.drawBitmap(bmp, src, dst, paint)
        }
    }
}



