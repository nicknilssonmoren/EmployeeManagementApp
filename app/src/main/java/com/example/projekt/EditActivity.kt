package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_activity)


        val context = this
        val db = DatabaseHandler(context)

        val etEmpIdEdit = findViewById<EditText>(R.id.etEmpIdEdit)
        val etEditName = findViewById<EditText>(R.id.etEditName)
        val etEditEmail = findViewById<EditText>(R.id.etEditEmail)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val readButton = findViewById<Button>(R.id.btn_read)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val result = findViewById<TextView>(R.id.result)

        fun casualRead(){
            var data = db.readData()
            result.text = ""
            for (i in 0 until data.size) {
                result.append(data[i].id.toString() + " " + data[i].name + " " + data[i].age + "\n")
            }
        }

        btnUpdate.setOnClickListener{
            casualRead()
            if(etEmpIdEdit.text.toString().isEmpty()){
                Toast.makeText(context, "You need to enter ID to update.", Toast.LENGTH_SHORT).show()
            }
            if(etEditName.text.toString().isEmpty()){
                db.updateDataColAge(etEmpIdEdit.text.toString().toInt(), etEditEmail.text.toString().toInt())
                Toast.makeText(context, "The email of ID: ${etEmpIdEdit.text} has been updated.", Toast.LENGTH_SHORT).show()
            }
            if(etEditEmail.text.toString().isEmpty()){
                db.updateDataColName(etEmpIdEdit.text.toString().toInt(), etEditName.text.toString())
                Toast.makeText(context, "The name of ID: ${etEmpIdEdit.text} has been updated.", Toast.LENGTH_SHORT).show()
            }
            if (etEditEmail.text.toString().isEmpty() && etEditName.text.toString().isEmpty()) {
                Toast.makeText(context, "Please fill out what you want to update.", Toast.LENGTH_SHORT).show()
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