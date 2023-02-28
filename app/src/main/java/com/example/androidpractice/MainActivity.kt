 package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

 class MainActivity : AppCompatActivity() {

     private lateinit var etFirstNumber: EditText
     private lateinit var etSecondNumber: EditText
     private lateinit var btnAdd: Button
     private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstNumber = findViewById(R.id.etFirstNumber)
        etSecondNumber = findViewById(R.id.etSecondNumber)
        btnAdd = findViewById(R.id.btnAdd)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener{
            var firstNumber = etFirstNumber.text.toString().toInt()
            var secondNumber = etSecondNumber.text.toString().toInt()
            var result = firstNumber + secondNumber
            tvResult.text = result.toString()
        }

    }

}