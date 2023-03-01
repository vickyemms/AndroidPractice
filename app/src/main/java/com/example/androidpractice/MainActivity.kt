 package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

     private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast = findViewById(R.id.btnToast)

        btnToast.setOnClickListener{
            Toast.makeText(this, "I am a Toast", Toast.LENGTH_LONG).show()
        }

    }

}