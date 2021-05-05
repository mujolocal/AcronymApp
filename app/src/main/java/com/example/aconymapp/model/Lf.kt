package com.example.aconymapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Lf(
    @Json(name = "freq")
    val freq: Int?,
    @Json(name = "lf")
    val lf: String?,
    @Json(name = "since")
    val since: Int?,
    @Json(name = "vars")
    val vars: List<Var>?
)