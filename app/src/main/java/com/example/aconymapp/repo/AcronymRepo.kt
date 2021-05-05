package com.example.aconymapp.repo

import com.example.aconymapp.repo.remote.RetrofitInstance


object AcronymRepo {

    private val acronymService = RetrofitInstance.ACRONYM_SERVICE

    suspend fun getAcronymResponse(acronym: String) = acronymService.getAcronym(acronym)
}