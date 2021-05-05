package com.example.aconymapp.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aconymapp.model.AcronymResponseItem
import com.example.aconymapp.repo.AcronymRepo
import com.example.aconymapp.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class SharedViewModel : ViewModel(){
    private  val TAG = "SharedViewModel"
    var acronym = ObservableField<String>()
    private val _apiState = MutableLiveData<ApiState<AcronymResponseItem>>()
    val apiState: LiveData<ApiState<AcronymResponseItem>>
        get() = _apiState

    fun getResponse() {
        _apiState.postValue(ApiState.Loading)
        try {
            Log.d(TAG, "getResponse: started")
            viewModelScope.launch(Dispatchers.IO) {
                acronym.get()?.let {
                _apiState.postValue(ApiState.Loading)
                val acronymResponse: List<AcronymResponseItem>? = AcronymRepo.getAcronymResponse(it)
                if (acronymResponse != null) {
                    Log.d(TAG, "getResponse:${acronymResponse} ")
                    _apiState.postValue(ApiState.Success(acronymResponse[0]))
                }
            }
        }
        }catch (e: Exception) {
            ApiState.Error("Network error, please try again.")
        }
    }

    fun toggleCompletedState() {
        _apiState.value = ApiState.Completed
    }

}