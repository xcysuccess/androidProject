package com.mediapedia.kotlinstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
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
}