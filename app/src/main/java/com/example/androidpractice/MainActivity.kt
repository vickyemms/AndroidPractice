 package com.example.androidpractice

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import android.Manifest

 class MainActivity : AppCompatActivity() {

     private lateinit var btnRequestPermission: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRequestPermission = findViewById(R.id.btnRequestPermission)

        btnRequestPermission.setOnClickListener {
            requestPermission()
        }
    }

     private fun hasWriteExternalStoragePermission() =
         ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

     private fun hasLocationForegroundPermission() =
         ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

     private fun hasLocationBackgroundPermission() =
         ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED


     private fun requestPermission(){
         var permissionsToRequest = mutableListOf<String>()
         if(!hasWriteExternalStoragePermission()) {
             permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
         }
         if(!hasLocationForegroundPermission()) {
             permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
         }
         if(!hasLocationBackgroundPermission()) {
             permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
         }

         if(permissionsToRequest.isNotEmpty()) {
             ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
         }
     }

     override fun onRequestPermissionsResult(
         requestCode: Int,
         permissions: Array<out String>,
         grantResults: IntArray
     ) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         if(requestCode == 0 && grantResults.isNotEmpty()){
             for (i in grantResults.indices){
                 if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                     Log.d("PermissionsRequest", "${permissions[i]} granted")
                 }
             }
         }
     }
 }