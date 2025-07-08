package com.example.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview: RecyclerView = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Item>()
        for (i in 1..15) {
            data.add(Item(R.drawable.gfg_logo, "Item $i"))
        }
        val adapter = Adapter(data)
        recyclerview.adapter = adapter

//        val byteVal: Byte = 127
//        val shortVal: Short = 32_000
//        val intVal: Int = 1_000_000
//        val longVal: Long = 1_000_000_000_000L
//
//        // Floating point types
//        val floatVal: Float = 3.14F
//        val doubleVal: Double = 3.14159265359
//
//        // Boolean type
//        val isKotlinFun: Boolean = true
//
//        // Character type
//        val grade: Char = 'A'
//
//        // String type
//        val name: String = "Kotlin"
//
//        // Print using Logcat
//        Log.d("DataTypesDemo", "Byte: $byteVal, Short: $shortVal, Int: $intVal, Long: $longVal")
//        Log.d("DataTypesDemo", "Float: $floatVal, Double: $doubleVal")
//        Log.d("DataTypesDemo", "Boolean: $isKotlinFun, Char: $grade, String: $name")
    }
}