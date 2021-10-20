package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)

        val btnBackToMenu = findViewById<Button>(R.id.btnBackToMenu)
        val results = findViewById<TextView>(R.id.textView2)
        val catImage = findViewById<ImageView>(R.id.imgCat)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://thatcopy.pw/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CatApi::class.java)
        val call = service.getInfo()

        call.enqueue(object : Callback<Cat> {
            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
                if (response.isSuccessful) {
                    val cat = response.body()!!

                    //val stringBuilder= "Cat: \n url ${cat.myUrl}"

                    //results.text = stringBuilder

                    Glide.with(this@AboutUsActivity)
                        .load(cat.myUrl)
                        .into(catImage)
                }
            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        btnBackToMenu.setOnClickListener{
            onBackPressed()
        }

    }
}