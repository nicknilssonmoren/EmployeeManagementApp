package com.example.projekt

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("catapi/rest/")
    fun getInfo(): Call<Cat>
}