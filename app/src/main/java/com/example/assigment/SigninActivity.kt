package com.example.assigment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SigninActivity : AppCompatActivity() {
    lateinit var  databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

    val etName=findViewById<TextInputEditText>(R.id.etName)
    val etPassword=findViewById<TextInputEditText>(R.id.etPassword)
    val etUserName=findViewById<TextInputEditText>(R.id.etUserName)
        val btnlogin=findViewById<Button>(R.id.btnlogin)


 btnlogin.setOnClickListener {

     val name=etName.text.toString()
     val password=etPassword.text.toString()
        val username= etUserName.text.toString()

     if(username.isNotEmpty()) {
         readData(username)
     }else{
         Toast.makeText(this, "Please enter all Detail", Toast.LENGTH_SHORT).show()
        }
    }

}

    private fun readData(username: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(username).get().addOnCanceledListener {

        }.addOnFailureListener {
            Toast.makeText(this, "user does not exist", Toast.LENGTH_SHORT).show()
        }

    }

}




