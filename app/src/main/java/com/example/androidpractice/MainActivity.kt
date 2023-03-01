 package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

 class MainActivity : AppCompatActivity() {

     private lateinit var btnImage: Button
     private lateinit var ivImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImage = findViewById(R.id.btnImage)
        ivImage = findViewById(R.id.ivImage)

        btnImage.setOnClickListener{
            ivImage.setImageResource(R.drawable.drawing)
        }

    }

}