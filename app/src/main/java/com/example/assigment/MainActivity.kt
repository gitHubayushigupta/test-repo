package com.example.assigment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.xml.sax.HandlerBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//splash screen  logo
         supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }, 3000)
        
    }
}