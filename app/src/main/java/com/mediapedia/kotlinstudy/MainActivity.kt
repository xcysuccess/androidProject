package com.mediapedia.kotlinstudy

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_first.setOnClickListener{
            //一.Intent启动方式
//            var intent = Intent(this,SecondActivity::class.java)
//            //1.intent传值
//            intent.putExtra("name","tomxiang的intent传递")
//            intent.putExtra("age",32)
//            startActivity(intent)

            //2.bundle传值
//            var bundle = Bundle()
//            bundle.putString("name", "tomxiang的bundle传递")
//            intent.putExtra("name", bundle)
//            startActivity(intent)

            //二.Intent启动方式（快捷）
            Intent(this, SecondActivity::class.java).apply {
//                putExtra("name","tomxiang的intent传递")
//                putExtra("age",32)
                putExtra("date", "2020-10-19")
                putExtra("user", User())
                startActivity(this)
            }
        }
    }


}

