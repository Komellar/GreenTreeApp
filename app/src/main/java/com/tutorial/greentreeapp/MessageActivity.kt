package com.tutorial.greentreeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_message.*

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        setSupportActionBar(findViewById(R.id.toolbar))

        //button click to get input and call sendEmail method
        btnSendMessage.setOnClickListener {
            //get input from EditTexts and save in variables
            val receiver = arrayOf("greentree@example.com")
            val subject = etTitle.text.toString().trim()
            val message = etText.text.toString().trim()

            //method call for email intent with these inputs as parameters
            composeEmail(receiver, subject, message)
        }

    }

    fun composeEmail(addresses: Array<String>, subject: String, message: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}