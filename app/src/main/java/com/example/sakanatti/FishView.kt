package com.example.sakanatti

import android.content.Context
import android.graphics.*
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
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
        var fishL = canvas.width / 3 + (150 * sin(0.1 * i.toDouble())).toInt()
        var fishT = canvas.height / 2 + (50 * sin(0.05 * i.toDouble())).toInt()
        var fishR = canvas.width / 3 + 500 + (150 * sin(0.1 * i.toDouble())).toInt()
        var fishB = canvas.height / 2 + 400 + (50 * sin(0.05 * i.toDouble())).toInt()
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.fish2_blue)
        val bmp0 = BitmapFactory.decodeResource(resources, R.drawable.e0760)
        val dst = Rect(fishL,fishT,fishR,fishB)
        val dst0 = Rect(canvas.width / 3 -200, canvas.height / 2 -500,
            canvas.width / 3 +300, canvas.height / 2 -100)
        i++

        val src = null
        canvas.drawBitmap(bmp, src, dst, paint)
        canvas.drawBitmap(bmp0,src,dst0,paint)

        invalidate()
    }

}