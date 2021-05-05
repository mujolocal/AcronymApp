package com.example.aconymapp.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Var(
    @Json(name = "freq")
    val freq: Int?,
    @Json(name = "lf")
    val lf: String?,
    @Json(name = "since")
    val since: Int?
) : Parcelable