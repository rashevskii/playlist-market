package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.settings)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backBtn = findViewById<Button>(R.id.back_from_settings)
        val mainIntent = Intent(this, MainActivity::class.java)

        backBtn.setOnClickListener { finish() }

        val shareBtn = findViewById<Button>(R.id.share_app_btn)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.putExtra(Intent.EXTRA_TEXT, "http://ya.ru")
        shareIntent.type = "text/plain"
        shareBtn.setOnClickListener { startActivity(shareIntent) }

        val writeSupportBtn = findViewById<Button>(R.id.write_to_support_btn)
        val subject = resources.getString(R.string.email_subject)
        val message = resources.getString(R.string.email_message)
        val mailIntent = Intent(Intent.ACTION_SENDTO)
        mailIntent.data = "mailto:".toUri()
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("rashevskii@yandex.ru"))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mailIntent.putExtra(Intent.EXTRA_TEXT, message)
        writeSupportBtn.setOnClickListener { startActivity(mailIntent) }

        val userAgreementBtn = findViewById<Button>(R.id.user_agreement_btn)
        val agreementIntent = Intent(Intent.ACTION_VIEW)
        agreementIntent.data = "https://yandex.ru/legal/practicum_offer/ru/".toUri()
        userAgreementBtn.setOnClickListener { startActivity(agreementIntent) }
    }
}