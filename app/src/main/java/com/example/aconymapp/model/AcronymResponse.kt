package com.example.aconymapp.model


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AcronymResponse( val responseItem: List<AcronymResponseItem>): Parcelable