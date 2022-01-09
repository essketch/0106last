package com.example.a0106last.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class StoreData (
        val id: Int,
        val name: String,
        @SerializedName("image_url")
        val logoURL: String,
        ) : Serializable {
}