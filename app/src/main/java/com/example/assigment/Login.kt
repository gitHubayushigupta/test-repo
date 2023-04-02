package com.example.assigment


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {


    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnSignUp=findViewById<Button>(R.id.btnSignUp)
        val etName=findViewById<TextInputEditText>(R.id.etName)
        val etPassword=findViewById<TextInputEditText>(R.id.etPassword)
        val etUserName=findViewById<TextInputEditText>(R.id.etUserName)
        val btntext=findViewById<TextView>(R.id.btntext)

     btnSignUp.setOnClickListener {

            val name=etName.text.toString()
            val password=etPassword.text.toString()
            val username=etUserName.text.toString()

            val user=Users(name, password, username)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(username).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "user Registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Faile", Toast.LENGTH_SHORT).show()


            }
        }
        btntext.setOnClickListener {
            val btnIntent=findViewById<TextView>(R.id.btntext)
            btnIntent.setOnClickListener {
                intent=Intent(applicationContext, SigninActivity::class.java)
                startActivity(intent)
            }
        }


        }

    }
