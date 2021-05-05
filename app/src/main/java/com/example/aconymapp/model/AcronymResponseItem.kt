package com.example.aconymapp.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AcronymResponseItem(
    @Json(name = "lfs")
    val lfs: List<Lf>?,
    @Json(name = "sf")
    val sf: String?
) : Parcelable