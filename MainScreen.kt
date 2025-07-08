package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.carts_API.CartActivity
import com.example.myapplication.product_Api.MainActivity3
import com.example.myapplication.demo.MainActivity2

class MainScreen : AppCompatActivity() {

    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btnApi1 : Button
    private lateinit var btnApi2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        btn1 =  findViewById(R.id.btn1)
        btn2 =  findViewById(R.id.btn2)
        btnApi1 =  findViewById(R.id.btnApi1)
        btnApi2 =  findViewById(R.id.btnApi2)
        btn1.setOnClickListener {
            val intent = Intent(this@MainScreen, MainActivity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this@MainScreen, MainActivity2::class.java)
            startActivity(intent)
        }
        btnApi1.setOnClickListener {
            val intent = Intent(this@MainScreen, MainActivity3::class.java)
            startActivity(intent)
        }
        btnApi2.setOnClickListener {
            val intent = Intent(this@MainScreen, CartActivity::class.java)
            startActivity(intent)
        }
    }
}