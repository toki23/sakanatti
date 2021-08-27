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

class FishView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var i = 0;

    var paint: Paint = Paint()
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
        invalidate()
    }

}