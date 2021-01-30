package com.mediapedia.kotlinstudy

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class MyService : Service() {

    inner class MyBinder : Binder() {
        val service: MyService
        get() = this@MyService
    }

    //通过binder实现调用者client与Service之间的通信
    private val binder = MyBinder()

    private val generator: Random = Random()

    override fun onBind(intent: Intent): IBinder {
        Log.i("xiao", "onBind - Thread ID = " + Thread.currentThread().id)
        return binder
    }

    override fun onCreate() {
        Log.i("xiao","onCreate - Thread ID = " + Thread.currentThread().id)
        super.onCreate()
    }

    override fun onDestroy() {
        Log.i("xiao", "onDestroy - Thread ID = " + Thread.currentThread().id)
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("xiao", "onStartCommand - startId = " + startId + ", Thread ID = " + Thread.currentThread().id)
        return super.onStartCommand(intent, flags, startId)
    }

    //getRandomNumber是Service暴露去供client调用的公共方法
    fun getRandomNumber(): Int{
        return generator.nextInt()
    }

}