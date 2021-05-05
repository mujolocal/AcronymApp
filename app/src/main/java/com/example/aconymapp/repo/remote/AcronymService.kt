package com.example.aconymapp.repo.remote


import com.example.aconymapp.model.AcronymResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AcronymService {

    @GET("dictionary.py")
    suspend fun getAcronym(@Query("sf") acronymName: String):  AcronymResponse

}