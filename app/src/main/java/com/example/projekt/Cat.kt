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
    var myX: Int = 0
    @SerializedName("y")
    var MyY: Int = 0

}