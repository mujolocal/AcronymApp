package com.example.aconymapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AcronymResponseItem(
    @Json(name = "lfs")
    val lfs: List<Lf>?,
    @Json(name = "sf")
    val sf: String?
)