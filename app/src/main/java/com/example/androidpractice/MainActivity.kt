 package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

 class MainActivity : AppCompatActivity() {

     private lateinit var rgMeat: RadioGroup
     private lateinit var cbCheese: CheckBox
     private lateinit var cbOnions: CheckBox
     private lateinit var cbSalad: CheckBox
     private lateinit var btnOrder: Button
     private lateinit var tvOrder: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rgMeat = findViewById(R.id.rgMeat)
        cbCheese = findViewById(R.id.cbCheese)
        cbOnions = findViewById(R.id.cbOnions)
        cbSalad = findViewById(R.id.cbSalad)
        btnOrder = findViewById(R.id.btnOrder)
        tvOrder = findViewById(R.id.tvOrder)

        btnOrder.setOnClickListener{
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You ordered a burger with:\n" +
                    "${meat.text}" +
                    (if(cheese) "\nCheese" else "") +
                    (if(onions) "\nOnions" else "") +
                    (if(salad) "\nSalad" else "")
            tvOrder.text = orderString
        }

    }

}