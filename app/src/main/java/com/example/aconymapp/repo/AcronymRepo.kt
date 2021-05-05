package com.example.aconymapp.repo

import com.example.aconymapp.repo.remote.RetrofitInstance


object AcronymRepo {

    private val tmobileService = RetrofitInstance.ACRONYM_SERVICE

    suspend fun getTmobileResponse() = tmobileService.getTmobileResponse()
}