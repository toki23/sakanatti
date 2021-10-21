package com.example.sakanatti

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FishGame : AppCompatActivity() {
    private var mCounter: Int = 0
    private var finishFlag = false
    val mpaint = Paint()
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_game)
        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        val linearLayout: LinearLayout = findViewById(R.id.canvasLayout)
        val myView = GameView(this)
        linearLayout.addView(myView, LinearLayout.LayoutParams(wrapContent, wrapContent))
        score = Score.get(applicationContext)
        val score5: TextView = findViewById(R.id.score_game)
        val returnbt: Button = findViewById(R.id.returnbt)
        returnbt.setOnClickListener {
//            val intent = Intent(this, FishActivity::class.java)
//            startActivity(intent)
            finish()
        }
        //時間計測↓
        val thread = Thread {
            while (!finishFlag) { //あたったときにこのループを抜けだす。
                val text = "score:$mCounter"
                runOnUiThread { score5.text = text }
                Thread.sleep(1000)
                mCounter++
            }
            if (mCounter > score) {
                Score.set(applicationContext, mCounter)
                runOnUiThread { score5.text = "$mCounter" }
            } else {
                runOnUiThread { score5.text = "$score" }
            }
        }
        thread.start()

        //score5.text = score.toString()
        //Log.i("aaa", score.toString())
    }

    inner class GameView constructor(
        context: Context
    ) : View(context) {
        private var cx = 100

        //private var cy = 0
        private var obstacle = Obstacle()
        private val bmp = BitmapFactory.decodeResource(resources, R.drawable.silhouette_fish_top)
        private val dst = Rect()
        var paint: Paint = Paint()
        private var i = 0
        private var speed = 7
        override fun onDraw(canvas: Canvas) {
            if (i == 0) {
                obstacle.init()
                if (speed < 47) {
                    speed++
                }
            }
            obstacle.drop()
            obstacle.draw(canvas)
            i++
            if (i >= height / speed) {
                i = 0
            }
            val fishL = cx - 120
            val fishT = height / 2 + 200
            val fishR = cx + 120
            val fishB = height / 2 + 600
            dst.set(fishL, fishT, fishR, fishB)
            canvas.drawBitmap(bmp, null, dst, paint)
            dst.set(fishL + 60, fishT + 30, fishR - 60, fishB - 60) //当たり判定の調整
//            if ((obstacle.left + 15 in fishL..fishR || obstacle.right - 15 in fishL..fishR) && (obstacle.top + 15 in fishT..fishB || obstacle.bottom - 15 in fishT..fishB)) {
            if (obstacle.dst2.intersect(dst)) {
                super.onDraw(canvas)
                finishFlag = true
                mpaint.textSize = 400f
                canvas.drawText("終了", width / 2 - 300f, height / 2f, mpaint)
                mpaint.textSize = 100f
                if (mCounter > score) {
                    canvas.drawText(
                        "ベストスコア${mCounter}pt",
                        width / 2 - 300f,
                        height / 2f + 300,
                        mpaint
                    )
                } else {
                    canvas.drawText("ベストスコア${score}pt", width / 2 - 300f, height / 2f + 300, mpaint)
                }
            }
            if (!finishFlag) {
                invalidate()
            }
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {    // (7)
            if (finishFlag) {
                return true
            }
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
//        invalidate() // (13)

            return true // (14)
        }

        override fun performClick(): Boolean {
            super.performClick()
            return true
        }

        inner class Obstacle {
            private var x: Int = (0..width).random()
            private var y: Int = 0
            private var left = 0
            private var top = 0
            private var right = 300
            private var bottom = 300
            private val bmp2 = BitmapFactory.decodeResource(resources, R.drawable.beer_1)
            val dst2 = Rect(left, top, right, bottom)

            fun init() {
                x = (0..width).random()
                y = 0
            }

            fun draw(canvas: Canvas) {
                dst2.set(left, top, right, bottom)
                canvas.drawBitmap(bmp2, null, dst2, paint)
            }

            fun drop() {
                y += speed
                left = x - 150
                top = y + 150
                right = x + 150
                bottom = y + 450
            }
        }
    }
}
//
//package com.example.sakanatti
//
//import android.content.Context
//import android.content.Intent
//import android.graphics.BitmapFactory
//import android.graphics.Canvas
//import android.graphics.Paint
//import android.graphics.Rect
//import android.os.Bundle
//import android.os.Handler
//import android.util.AttributeSet
//import android.util.Log
//import android.view.MotionEvent
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//
//class FishGame : AppCompatActivity() {
//    private var mHandler = Handler()
//    private var mCounter: Int = 0
//    private var finishFlag = false
//
//    private var score = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fish_game)
//
//        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
//        val linearLayout: LinearLayout = findViewById(R.id.canvasLayout)
//        val myView = GameView(this)
//        linearLayout.addView(myView, LinearLayout.LayoutParams(wrapContent, wrapContent))
//
//
//        val score5: TextView = findViewById(R.id.score_game)
//        val returnbt: Button = findViewById(R.id.returnbt)
//        score = Score.get(applicationContext)
//        returnbt.setOnClickListener {
//            val intent = Intent(this, FishActivity::class.java)
//            startActivity(intent)
//        }
//        //時間計測↓
//        Log.i("sample", score.toString())
//        val thread = Thread {
//            try {
//                while (!finishFlag) { //あたったときにこのループを抜けだす。
//                    mHandler.post {
//                        //numに経過時間を代入
//                        val text = "score:$mCounter"
//                        score5.text = text
//                    }
//                    Thread.sleep(1000)
//                    mCounter++
//                }
//                if (mCounter > score) {
//                    Log.i("sample", mCounter.toString())
//                    Score.set(applicationContext, mCounter)
//                    score5.text = "$mCounter"
//                } else {
//                    score5.text = "$score"
//                }
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//        }
//        thread.start()
//        //score5.text = score.toString()
//        //Log.i("aaa", score.toString())
//    }
//
//    internal inner class GameView @JvmOverloads constructor(
//        context: Context,
//        attrs: AttributeSet? = null,
//        defStyleAttr: Int = 0
//    ) : View(context, attrs, defStyleAttr) {
//        private var cx = 100
//
//        //private var cy = 0
//        private var obstacle = Obstacle(200)
//        private val bmp = BitmapFactory.decodeResource(resources, R.drawable.silhouette_fish_top)
//        private val dst = Rect()
//        var paint: Paint = Paint()
//        private var i = 0;
//        private var speed = 7;
//        override fun onDraw(canvas: Canvas) {
//
//
//            if (i == 0) {
//                obstacle = Obstacle((0..800).random());
//            }
//            obstacle.drop()
//            obstacle.draw(canvas)
//            i++
//            if (i >= canvas.height / speed) {
//                i = 0;
//            }
//            val fishL = cx - 120
//            val fishT = height / 2 + 200
//            val fishR = cx + 120
//            val fishB = height / 2 + 600
//            dst.set(fishL, fishT, fishR, fishB)
//            canvas.drawBitmap(bmp, null, dst, paint)
//            if ((obstacle.left + 15 in fishL..fishR || obstacle.right - 15 in fishL..fishR) && (obstacle.top + 15 in fishT..fishB || obstacle.bottom - 15 in fishT..fishB)) {
//                val mpaint = Paint();
//                super.onDraw(canvas);
//                finishFlag = true
//                mpaint.setTextSize(400f)
//                canvas.drawText("終了", 200f, 600f, mpaint);
//                mpaint.setTextSize(100f)
//                canvas.drawText("ベストスコア", 250f, 800f, mpaint)
//                if (mCounter > score) {
//                    canvas.drawText("${mCounter }pt", 450F, 1000F, mpaint)
//                } else {
//                    canvas.drawText("${score}pt", 450F, 1000F, mpaint)
//                }
//
//            }
//
//            if (!finishFlag) {
//
//                invalidate()
//            }
//        }
//
//        override fun onTouchEvent(event: MotionEvent): Boolean {    // (7)
//            if (finishFlag) {
//                return true
//            }
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> assert(
//                    true // 何もしない
//                )
//                MotionEvent.ACTION_MOVE -> {
//                    cx = event.x.toInt() // (10)
//                    //cy = event.y.toInt() // (11)
//                    performClick()
//                }
//                MotionEvent.ACTION_UP -> assert(
//                    true // 何もしない
//                )
//                else -> assert(
//                    true // 何もしない
//                )
//            }
////        invalidate() // (13)
//
//            return true // (14)
//        }
//
//        override fun performClick(): Boolean {
//            super.performClick()
//            return true
//        }
//
//        inner class Obstacle constructor(
//            private var x: Int,
//            private var y: Int = 0,
//        ) {
//            var left = 0
//                private set
//            var top = 0
//                private set
//            var right = 300
//                private set
//            var bottom = 300
//                private set
//            private val bmp2 = BitmapFactory.decodeResource(resources, R.drawable.beer_1)
//            private val dst2 = Rect(left, top, right, bottom)
//
//            fun draw(canvas: Canvas) {
//                dst2.set(left, top, right, bottom)
//                canvas.drawBitmap(bmp2, null, dst2, paint)
//            }
//
//            fun drop() {
//                y += speed
//                left = x - 150
//                top = y + 150
//                right = x + 150
//                bottom = y + 450
//            }
//        }
//
//    }
//
//
