package com.example.aconymapp.util


import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:toggleButtonState")
fun <T> MaterialButton.toggleButtonState(state: ApiState<T>?) {
    val isLoading = state is ApiState.Loading
    isEnabled = isLoading.not()
}

@BindingAdapter("app:toggleProgressState")
fun <T> ProgressBar.toggleProgressState(state: ApiState<T>?) {
    visibility = if (state is ApiState.Loading) View.VISIBLE else View.GONE
}
@BindingAdapter(value = ["app:stateLD", "app:query"])
fun <T> TextInputLayout.toggleSearchState(
    stateLD: LiveData<ApiState<T>?>,
    query: ObservableField<String>? = null
) {
    val apiState = stateLD.value
    if (apiState is ApiState.Error) error = apiState.msg
    isErrorEnabled = apiState is ApiState.Error || query?.get().isNullOrBlank()
}
