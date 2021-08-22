package com.example.sakanatti

import android.R.attr
import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.R.attr.src





class FishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myView = MyView(this)
        setContentView(myView)
    }
    internal inner class MyView(context: Context) : View(context) {
        private var paint: Paint = Paint()
        private val TAG = "fish canvas"
        // 描画するラインの太さ
        private val lineStrokeWidth = 20f

        init {
        }

        override fun onDraw(canvas: Canvas){

            // ペイントする色の設定
            val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
            val w: Int = bmp.width
            val h: Int = bmp.height
            Log.i(TAG, w.toString())
            Log.i(TAG,h.toString())
            val dst = Rect(0, 0, 500, 400)
            val src = null
            canvas.drawBitmap(bmp, src, dst, paint)
        }
    }
}


