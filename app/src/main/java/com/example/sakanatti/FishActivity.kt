package com.example.sakanatti

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sin


class FishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fish)
        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        val linearLayout: LinearLayout = findViewById(R.id.fishLayout)
        val myView = FishView(this)
        linearLayout.addView(myView, LinearLayout.LayoutParams(wrapContent,wrapContent))
        var count = 0
        val btn1: Button = findViewById(R.id.id)
        val tx1: TextView = findViewById(R.id.textView)
        val data = Database.select(applicationContext)
        val img2: ImageView = findViewById(R.id.img2)
        img2.setImageResource(R.drawable.beer_1)
        val img3: ImageView = findViewById(R.id.img3)
        img3.setImageResource(R.drawable.gomi_3)
        val img4: ImageView = findViewById(R.id.img4)
        img4.setImageResource(R.drawable.banana_1)
        val img5: ImageView = findViewById(R.id.img5)
        img5.setImageResource(R.drawable.sinnbunn_1)
        img2.visibility = View.INVISIBLE
        img3.visibility = View.INVISIBLE
        img4.visibility = View.INVISIBLE
        img5.visibility = View.INVISIBLE
        val score0 = data[0]
        val score1 = data[1]
        val score2 = data[2]
        val score3 = data[3]

        btn1.setOnClickListener {
            count++
            if (score0 == 6 && score1 == 6 && score2 == 6 && score3 == 6 && count == 1) {
                tx1.text = "タップしてゲームを開始"
            } else if (score0 == 6 && score1 == 6 && score2 == 6 && score3 == 6 && count == 2) {
                val intent = Intent(applicationContext, FishGame::class.java)
                startActivity(intent)
            }

            when (count) {
                1 -> when (score0) {
                    1 -> {
                        tx1.text = "床がかなり散らかっています。"
                        img2.visibility = View.VISIBLE
                    }
                    2 -> {
                        tx1.text = "床が散らかっています。"
                        img2.visibility = View.VISIBLE
                    }
                    3 -> {
                        tx1.text = "床を掃除しよう。"
                    }
                    4 -> {
                        tx1.text = "床を確認しよう。"
                    }
                    5 -> {
                        tx1.text = "床はきれいですね。"
                    }

                }
                2 -> when (score1) {//1
                    1 -> {
                        tx1.text = "机の上がかなり散らかっています。"
                        img3.visibility = View.VISIBLE
                    }
                    2 -> {
                        tx1.text = "机が散らかっています。"
                        img3.visibility = View.VISIBLE
                    }
                    3 -> {
                        tx1.text = "机を掃除しよう。"
                    }
                    4 -> {
                        tx1.text = "机を確認しよう。"
                    }
                    5 -> {
                        tx1.text = "机はきれいですね。"
                    }
                }
                3 -> when (score2) {//2
                    1 -> {
                        tx1.text = "本がかなり散らかっています。"
                        img4.visibility = View.VISIBLE
                    }
                    2 -> {
                        tx1.text = "本が散らかっています。"
                        img4.visibility = View.VISIBLE
                    }
                    3 -> {
                        tx1.text = "本を掃除しよう。"
                    }
                    4 -> {
                        tx1.text = "本を確認しよう。"
                    }
                    5 -> {
                        tx1.text = "本はきれいですね。"
                    }
                }
                4 -> when (score3) {//3
                    1 -> {
                        tx1.text = "服がかなり散らかっています。"
                        img5.visibility = View.VISIBLE
                    }
                    2 -> {
                        tx1.text = "服が散らかっています。"
                        img5.visibility = View.VISIBLE
                    }
                    3 -> {
                        tx1.text = "服を掃除しよう。"
                    }
                    4 -> {
                        tx1.text = "服を確認しよう。"
                    }
                    5 -> {
                        tx1.text = "服はきれいですね。"
                    }
                }
                5, 6 -> {
                    if (count == 5) {
                        tx1.text = "タップしてゲームを開始"
                    } else {
                        val intent = Intent(applicationContext, FishGame::class.java)
                        startActivity(intent)
                    }

                }
            }
        }
    }
    internal inner class FishView @JvmOverloads constructor(
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
}



