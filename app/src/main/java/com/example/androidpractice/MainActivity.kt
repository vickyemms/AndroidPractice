 package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

 class MainActivity : AppCompatActivity() {

     private lateinit var btnDialog1: Button
     private lateinit var btnDialog2: Button
     private lateinit var btnDialog3: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDialog1 = findViewById(R.id.btnDialog1)
        btnDialog2 = findViewById(R.id.btnDialog2)
        btnDialog3 = findViewById(R.id.btnDialog3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Amanda to your contact list?")
            .setIcon(R.drawable.ic_add_contact_foreground)
            .setPositiveButton("Yes") {_, _ ->
                Toast.makeText(this, "You have added Amanda to your contact list.", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You have not added Amanda to your contact list.", Toast.LENGTH_LONG).show()
            }.create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First", "Second", "Third")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") {_, _ ->
                Toast.makeText(this, "You accepted your choice.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You declined your choice.", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { dialogInterface, i, isChecked ->
                if (isChecked){
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "You unchecked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") {_, _ ->
                Toast.makeText(this, "You accepted your choice.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You declined your choice.", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }


    }

 }