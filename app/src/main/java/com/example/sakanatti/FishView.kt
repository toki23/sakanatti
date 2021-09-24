package com.example.sakanatti

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlin.math.sin

class FishView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var i = 0
    private val paint: Paint = Paint()
    private val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
    private val bmp0 = BitmapFactory.decodeResource(resources, R.drawable.e0760)
    private val dst = Rect()
    private val dst0 = Rect()
    override fun onDraw(canvas: Canvas) {
        val fishL = width / 3 + (150 * sin(0.1 * i.toDouble())).toInt()
        val fishT = height / 2 + (50 * sin(0.05 * i.toDouble())).toInt()
        val fishR = width / 3 + 500 + (150 * sin(0.1 * i.toDouble())).toInt()
        val fishB = height / 2 + 400 + (50 * sin(0.05 * i.toDouble())).toInt()
        dst.set(fishL, fishT, fishR, fishB)
        dst0.set(
            width / 3 - 200, height / 2 - 500,
            width / 3 + 300, height / 2 - 100
        )
        i++
        canvas.drawBitmap(bmp, null, dst, paint)
        canvas.drawBitmap(bmp0, null, dst0, paint)
        invalidate()
    }
}