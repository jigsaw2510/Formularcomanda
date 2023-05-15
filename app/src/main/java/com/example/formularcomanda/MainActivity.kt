package com.example.formularcomanda

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat.getDateInstance
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewDate = findViewById<TextView>(R.id.text_view_current_date)
        val nextPageButton = findViewById<Button>(R.id.button)
        val sdf =  getDateInstance()
        val currentDate = sdf.format(Date())
        textViewDate.text = "Data: $currentDate"

        nextPageButton.setOnClickListener {
            val intent = Intent(this, UploadFile::class.java)
            startActivity(intent)
        }

    }


}