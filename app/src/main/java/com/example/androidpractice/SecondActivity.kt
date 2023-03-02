package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var tvPerson: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvPerson = findViewById(R.id.tvPerson)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvPerson.text = person.toString()

    }
}