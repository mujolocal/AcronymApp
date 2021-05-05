package com.example.aconymapp.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://www.nactem.ac.uk/software/acromine/"

    private val client = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }.let { loginIntercept -> OkHttpClient.Builder().addInterceptor(loginIntercept).build() }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val ACRONYM_SERVICE: AcronymService by lazy { retrofit.create(AcronymService::class.java) }
}