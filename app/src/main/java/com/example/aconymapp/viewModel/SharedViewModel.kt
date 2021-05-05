package com.example.aconymapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aconymapp.model.AcronymResponse
import com.example.aconymapp.repo.AcronymRepo
import com.example.aconymapp.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SharedViewModel : ViewModel(){
    private  val TAG = "SharedViewModel"
    private val _apiState = MutableLiveData<ApiState<AcronymResponse?>>()
    val apiState: LiveData<ApiState<AcronymResponse?>>
        get() = _apiState

//    fun getResponse(acronym:String) {
fun getResponse() {
        _apiState.postValue(ApiState.Loading)
        try {
            Log.d(TAG, "getResponse: started")
            viewModelScope.launch(Dispatchers.IO) {
                _apiState.postValue(ApiState.Loading)
//                val acronymResponse: AcronymResponse? = AcronymRepo.getAcronymResponse(acronym)
                val acronymResponse: AcronymResponse? = AcronymRepo.getAcronymResponse("fe")
                if (acronymResponse != null) {
                    Log.d(TAG, "getResponse:${acronymResponse} ")
                    _apiState.postValue(ApiState.Success(acronymResponse))
                }
            }
        } catch (e: Exception) {
            ApiState.Error("Network error, please try again.")
        }
    }

    fun toggleCompletedState() {
        _apiState.value = ApiState.Completed
    }

}