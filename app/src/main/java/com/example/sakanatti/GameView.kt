package com.example.sakanatti

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var cx = 100

    //private var cy = 0
    private var obstacle = Obstacle(200)
    private val bmp = BitmapFactory.decodeResource(resources, R.drawable.silhouette_fish_top)
    private val dst = Rect()
    var paint: Paint = Paint()
    private var i = 0;
    private var speed = 4;
    override fun onDraw(canvas: Canvas) {
        if(i == 0){

            obstacle = Obstacle((0..800).random());

        }
        obstacle.draw(canvas)
        obstacle.drop()
        i++
        if(i >= canvas.height/speed){
            i = 0;
        }
        Log.i("canvas",canvas.height.toString())
        val fishL = cx - 120
        val fishT = height / 2 + 200
        val fishR = cx + 120
        val fishB = height / 2 + 600
        dst.set(fishL, fishT, fishR, fishB)
        canvas.drawBitmap(bmp, null, dst, paint)
        if ((obstacle.left in fishL..fishR || obstacle.right in fishL..fishR) && (obstacle.top in fishT..fishB || obstacle.bottom in fishT..fishB)) {
            Log.i("aaa", "あたった")
            /****
             *
             *
             *
             *    ここに当たった時の処理を書く
             *
             *
             *
             *
             */
        }
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {    // (7)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> assert(
                true // 何もしない
            )
            MotionEvent.ACTION_MOVE -> {
                cx = event.x.toInt() // (10)
                //cy = event.y.toInt() // (11)
                performClick()
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

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    inner class Obstacle constructor(
        private var x: Int,
        private var y: Int = 0,
    ) {
        var left = 0
            private set
        var top = 0
            private set
        var right = 300
            private set
        var bottom = 300
            private set
        private val bmp2 = BitmapFactory.decodeResource(resources, R.drawable.beer_1)
        private val dst2 = Rect(left, top, right, bottom)

        fun draw(canvas: Canvas) {
            dst2.set(left, top, right, bottom)
            canvas.drawBitmap(bmp2, null, dst2, paint)
        }

        fun drop() {
            y += speed
            left = x - 150
            top = y - 150
            right = x + 150
            bottom = y + 150
        }
    }
<<<<<<< Updated upstream
}
=======


}



>>>>>>> Stashed changes
