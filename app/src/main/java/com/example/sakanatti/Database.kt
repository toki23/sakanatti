package com.example.sakanatti

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class Database(
    context: Context,
    databaseName: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, databaseName, factory, version) {
    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("create table score (date TEXT, score1 INTEGER, score2 INTEGER, score3 INTEGER, score4 INTEGER)")
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            database?.execSQL("alter table score add column deleteFlag integer default 0")
        }
    }

    companion object {
        fun insert(context: Context, s1: Int, s2: Int, s3: Int, s4: Int) {
            val dbHelper = Database(context, "score", null, 1)
            val database = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("date", SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN).format(Date()))
            values.put("score1", s1)
            values.put("score2", s2)
            values.put("score3", s3)
            values.put("score4", s4)
            database.insert("score", null, values)
            database.close()
            dbHelper.close()
        }

        fun select(context: Context): List<Int> {
            val dbHelper = Database(context, "score", null, 1)
            val database = dbHelper.readableDatabase
            val data = mutableListOf(0, 0, 0, 0)
            val cursor = database.rawQuery("select * from score", null)
            if (cursor.count > 0) {
                cursor.moveToFirst()
                while (!cursor.isAfterLast) {
                    Log.i("sample", cursor.getInt(1).toString())
                    data[0] = (cursor.getInt(1))
                    data[1] = (cursor.getInt(2))
                    data[2] = (cursor.getInt(3))
                    data[3] = (cursor.getInt(4))
                    cursor.moveToNext()
                }
            }
            cursor.close()
            database.close()
            dbHelper.close()
            Log.i("sample", data.toString())
            return data
        }
    }
}

object Score {
    fun set(context: Context, score: Int) {
        val sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        sharedPref.edit().putInt("s", score).apply()
    }

    fun get(context: Context): Int {
        val sharedPref = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        return sharedPref.getInt("s", -1)
    }
}