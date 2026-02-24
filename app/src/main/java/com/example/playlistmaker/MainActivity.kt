package com.example.playlistmaker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById<Button>(R.id.search_btn)
        val mediaBtn = findViewById<Button>(R.id.media_btn)
        val settingsBtn = findViewById<Button>(R.id.settings_btn)

        val onSearchClick: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, "Search button clicked!", Toast.LENGTH_SHORT).show()
            }
        }

        searchBtn.setOnClickListener(onSearchClick)
        mediaBtn.setOnClickListener { Toast.makeText(this@MainActivity, "Media button clicked!", Toast.LENGTH_SHORT).show() }
        settingsBtn.setOnClickListener { Toast.makeText(this@MainActivity, "Settings button clicked!", Toast.LENGTH_SHORT).show() }
    }
}