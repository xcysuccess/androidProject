package com.mediapedia.kotlinstudy

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

//https://developer.android.com/guide/components/bound-services?hl=zh-cn
class SecondActivity : AppCompatActivity() {

    private var service: MyService? = null
    private var isBind = false

    private var conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            isBind = true
            var myBinder = binder as MyService.MyBinder
            service = myBinder.service
            Log.i("xiao", "ActivityA - onServiceConnected")
            var num = service!!.getRandomNumber()
            Log.i("xiao", "ActivityA - getRandomNumber = $num");
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBind = false
            Log.i("xiao", "ActivityA - onServiceDisconnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        registerService()
        //一. 值传递
//        val name = intent.extras?.getString("name")
//        val name  = intent.getStringExtra("name")
//        val age  = intent.getIntExtra("age", 0).toString()
//        tv_content.text = name
//        tv_age.text = age

        //二. 对象传递
//        var user = intent.getParcelableExtra<User>("user") as User
//        var date = intent.getStringExtra("date")
//        tv_content.text = user.name
//        tv_age.text = user.age.toString()

        tv_second.setOnClickListener {
            Intent(this,ThirdActivity::class.java).apply {
                putExtras(intent.extras!!)
                startActivity(this)
            }
        }
    }

    private fun registerService() {
        button_startservice.setOnClickListener {
            startService(Intent(this, MyService::class.java).apply {
                Log.d("Service","启动了服务")
            })
        }
        button_stopservice.setOnClickListener {
            stopService(Intent(this, MyService::class.java).apply {
                Log.d("Service","关闭服务")
            })
        }
        button_bindservice.setOnClickListener {
            if(!isBind) {
                Log.d("Service","绑定服务")
                val intent = Intent(this, MyService::class.java)
                bindService(intent, conn, Context.BIND_AUTO_CREATE)
                isBind = true
            }
        }
        button_unbindservice.setOnClickListener {
            if(isBind) {
                Log.d("Service","解绑服务")
                unbindService(conn)
                isBind = false
            }
        }
        button_getnumvalue.setOnClickListener {
            if(service != null) {
                var num = service!!.getRandomNumber()
                Log.d("Service", "num:$num")
            }
        }


    }
}