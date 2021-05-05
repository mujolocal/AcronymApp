package com.example.aconymapp.util

sealed class ApiState<out R> {
    data class Success<out R>(val cards: R) : ApiState<R>()
    data class Error(val msg: String) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
    object Completed : ApiState<Nothing>()
}
