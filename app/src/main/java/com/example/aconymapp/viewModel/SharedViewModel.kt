package com.example.aconymapp.viewModel


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


class SharedViewModel : ViewModel() {
    var acronym = ObservableField<String>()
    private val _apiState = MutableLiveData<ApiState<AcronymResponseItem>>()
    val apiState: LiveData<ApiState<AcronymResponseItem>>
        get() = _apiState

    fun getResponse() {
        _apiState.postValue(ApiState.Loading)
        try {
            viewModelScope.launch(Dispatchers.IO) {
                acronym.get()?.let {
                    _apiState.postValue(ApiState.Loading)
                    val acronymResponse: List<AcronymResponseItem>? =
                        AcronymRepo.getAcronymResponse(it)
                    if (acronymResponse.isNullOrEmpty()) {
                        _apiState.postValue(ApiState.Completed)
                    } else {
                        _apiState.postValue(ApiState.Success(acronymResponse[0]))
                    }
                }
            }
        } catch (e: Exception) {
            ApiState.Error("Network error, please try again.")
        }
    }

    fun toggleCompletedState() {
        _apiState.postValue(ApiState.Completed)
    }

}