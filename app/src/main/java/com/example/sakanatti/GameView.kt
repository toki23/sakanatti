package com.example.sakanatti

import android.content.Context
import android.graphics.*
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.sakanatti.R
import java.lang.Math.sin
import android.view.MotionEvent




class GameView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()

    private var cx = 0
    private var cy = 0
    override fun onDraw(canvas: Canvas) {

        var fishL = cx
        var fishT = canvas.height/2
        var fishR = cx + 500
        var fishB =canvas.height/2+ 400
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
        val dst = Rect(fishL,fishT,fishR,fishB)



        val src = null
        canvas.drawBitmap(bmp, src, dst, paint)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {    // (7)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> assert(
                true // 何もしない
            )
            MotionEvent.ACTION_MOVE -> {
                cx = event.x.toInt() // (10)
                cy = event.y.toInt() // (11)
            }
            MotionEvent.ACTION_UP -> assert(
                true // 何もしない
            )
            else -> assert(
                true // 何もしない
            )
        }
        invalidate() // (13)
        return true // (14)
    }

}