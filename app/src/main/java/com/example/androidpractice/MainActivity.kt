 package com.example.androidpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

 class MainActivity : AppCompatActivity() {

     private lateinit var btnChoosePhoto: Button
     private  lateinit var ivPhoto: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChoosePhoto = findViewById(R.id.btnChoosePhoto)
        ivPhoto = findViewById(R.id.ivPhoto)

        btnChoosePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if(resultCode == Activity.RESULT_OK && requestCode == 0){
             val uri = data?.data
             ivPhoto.setImageURI(uri)
         }
     }

 }