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

        val btnAddEmp = findViewById<Button>(R.id.btnAddEmp)
        val btnEditEmp = findViewById<Button>(R.id.btnEditEmp)
        val btnDelEmp = findViewById<Button>(R.id.btnDelEmp)
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)
        val btnAbout = findViewById<Button>(R.id.btnAbout)



        btnAddEmp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnEditEmp.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }

        btnDelEmp.setOnClickListener {
            startActivity(Intent(this, DeleteActivity::class.java))
        }

        btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

    }
}