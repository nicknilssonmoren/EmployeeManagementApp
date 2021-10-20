package com.example.projekt

import com.google.gson.annotations.SerializedName

class Cat {
    @SerializedName("id")
    var myId: Int = 0
    @SerializedName("url")
    var myUrl: String = ""
    @SerializedName("webpurl")
    var myWebpurl: String = ""
    @SerializedName("x")
    var myX: Double = 0.0
    @SerializedName("y")
    var MyY: Double = 0.0

}