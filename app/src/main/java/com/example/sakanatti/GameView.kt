package com.example.sakanatti

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.MotionEvent


class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var paint: Paint = Paint()

    private var cx = 0
    private var cy = 0
    private var i = 0


    var obstacle = Obstacle(200)

    override fun onDraw(canvas: Canvas) {

        obstacle.draw(canvas)
        obstacle.drop()
        var fishL = cx
        var fishT = canvas.height / 2 + 200
        var fishR = cx + 300
        var fishB = canvas.height / 2 + 600
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.silhouette_fish_top)
        val dst = Rect(fishL, fishT, fishR, fishB)


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

    inner class Obstacle constructor(_x: Int) {
        var x: Int = 0
        var y: Int = 0
        var Left = 0
        var Top = 0
        var Right = 300
        var Bottom = 300
        lateinit var canvas: Canvas

        init {
            x = _x
        }

        fun draw(canvas: Canvas) {

            val bmp = BitmapFactory.decodeResource(resources, R.drawable.beer_1)
            val dst = Rect(Left, Top, Right, Bottom)
            val src = null
            canvas.drawBitmap(bmp, src, dst, paint)

        }

        fun drop() {
            y++
            Left = x
            Top = y
            Right = x + 300
            Bottom = y + 300
        }
    }


}