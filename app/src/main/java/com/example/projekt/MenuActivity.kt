package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnShowEmp = findViewById<Button>(R.id.btnShowEmp)
        val btnAddEmp = findViewById<Button>(R.id.btnAddEmp)
        val btnDelEmp = findViewById<Button>(R.id.btnDelEmp)
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)

        btnAddEmp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnDelEmp.setOnClickListener {
            println("I MENU")
            startActivity(Intent(this, DeleteActivity::class.java))
        }

    }
}