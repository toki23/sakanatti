package com.example.sakanatti

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FishGame : AppCompatActivity() {
    internal var mHandler = Handler()
    internal var mCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_game)

        val score5: TextView = findViewById(R.id.score_game)
        val returnbt: Button = findViewById(R.id.returnbt)
        var num: Int

        returnbt.setOnClickListener {
            val intent = Intent(this, FishActivity::class.java)
            startActivity(intent)
        }
        //時間計測↓
        val thread = Thread(Runnable {
            try {
                mCounter = 0
                while (true) {
                    mHandler.post {
                        num = (mCounter + 1)//numに経過時間を代入
                        val text = "score:$num"
                        score5.text = text
                    }
                    Thread.sleep(1000)
                    mCounter++
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })
        thread.start()






        Score.set(applicationContext, 10)
        val score = Score.get(applicationContext)
        Log.i("aaa", score.toString())
    }
}