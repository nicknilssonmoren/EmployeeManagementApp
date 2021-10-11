package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var tvUserId: TextView
    private lateinit var tvEmailId: TextView
    private lateinit var btnLogout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUserId = findViewById(R.id.tv_user_id)
        tvEmailId = findViewById(R.id.tv_email_id)
        btnLogout = findViewById(R.id.btn_logout)


        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        tvUserId.text = "User ID :: $userId"
        tvEmailId.text = "Email ID :: $emailId"

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}