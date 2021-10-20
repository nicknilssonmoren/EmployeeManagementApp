package com.example.projekt

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("catapi/")
    fun getInfo(): Call<Cat>
}