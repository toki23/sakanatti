package com.example.sakanatti

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sin


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

        var i = 0
        override fun onDraw(canvas: Canvas) {


            val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
            val dst = Rect(
                canvas.width / 3 + (150 * sin(0.1 * i.toDouble())).toInt(),
                canvas.height / 2 + (50 * sin(0.05 * i.toDouble())).toInt(),
                +canvas.width / 3 + 500 + (150 * sin(0.1 * i.toDouble())).toInt(),
                canvas.height / 2 + 400 + (50 * sin(0.05 * i.toDouble())).toInt()
            )
            i++

            val src = null
            canvas.drawBitmap(bmp, src, dst, paint)
            Log.d("aa", "fjdajf")
            invalidate()
    }
    }

}



