package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        val db = DatabaseHandler(context)

        val readButton = findViewById<Button>(R.id.btn_read)
        val insertButton = findViewById<Button>(R.id.btn_insert)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val inputName = findViewById<EditText>(R.id.inputName)
        val inputAge = findViewById<EditText>(R.id.inputAge)
        val result = findViewById<TextView>(R.id.result)

        fun casualRead(){
            var data = db.readData()
            result.text = ""
            for (i in 0 until data.size) {
                result.append(data[i].id.toString() + " " + data[i].name + " " + data[i].age + "\n")
            }
        }

        insertButton.setOnClickListener{
            if (inputName.text.toString().isNotEmpty() && inputAge.text.toString().isNotEmpty()) {
                val user = User(inputName.text.toString(), inputAge.text.toString().toInt())
                db.insertData(user)
                casualRead()
            } else {
                Toast.makeText(context, "Please fill out the forms", Toast.LENGTH_SHORT).show()
            }
        }

        readButton.setOnClickListener{
            var data = db.readData()
            result.text = ""
            for (i in 0 until data.size) {
                result.append(data[i].id.toString() + " " + data[i].name + " " + data[i].age + "\n")
            }
        }

        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

    }
}