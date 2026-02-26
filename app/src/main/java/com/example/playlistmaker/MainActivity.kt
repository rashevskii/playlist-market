package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById<Button>(R.id.search_btn)
        val mediaBtn = findViewById<Button>(R.id.media_btn)
        val settingsBtn = findViewById<Button>(R.id.settings_btn)

        val settingsIntent = Intent(this, SettingsActivity::class.java)
        val mediaIntent = Intent(this, MediaActivity::class.java)
        val searchIntent = Intent(this, SearchActivity::class.java)

        searchBtn.setOnClickListener { startActivity(searchIntent) }
        mediaBtn.setOnClickListener { startActivity(mediaIntent) }
        settingsBtn.setOnClickListener { startActivity(settingsIntent) }
    }
}