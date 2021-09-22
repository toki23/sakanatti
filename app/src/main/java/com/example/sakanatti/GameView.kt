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

class GameView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()
    override fun onDraw(canvas: Canvas) {

        var fishL = canvas.width / 3
        var fishT = canvas.height / 2
        var fishR = canvas.width / 3 + 500
        var fishB = canvas.height / 2 + 400
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
        val dst = Rect(fishL,fishT,fishR,fishB)



        val src = null
        canvas.drawBitmap(bmp, src, dst, paint)
        invalidate()
    }

}