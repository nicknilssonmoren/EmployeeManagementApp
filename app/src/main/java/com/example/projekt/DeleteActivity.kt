package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        val context = this
        val db = DatabaseHandler(context)

        val readButton = findViewById<Button>(R.id.btn_read)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val inputId = findViewById<EditText>(R.id.inputId)
        val result = findViewById<TextView>(R.id.result)

        fun casualRead(){
            var data = db.readData()
            result.text = ""
            for (i in 0 until data.size) {
                result.append(data[i].id.toString() + " " + data[i].name + " " + data[i].age + "\n")
            }
        }

        casualRead()

        readButton.setOnClickListener{
            casualRead()
        }

        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btnDelete.setOnClickListener {
            if (inputId.text.toString().isNotEmpty()) {
                db.deleteData(inputId.text.toString().toInt())
                casualRead()
            } else {
                Toast.makeText(context, "Fill Employee ID to delete.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}