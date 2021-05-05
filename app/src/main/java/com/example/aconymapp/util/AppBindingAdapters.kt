package com.example.aconymapp.util


import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton


@BindingAdapter("app:toggleButtonState")
fun <T> MaterialButton.toggleButtonState(state: ApiState<T>?) {
    val isLoading = state is ApiState.Loading
    isEnabled = isLoading.not()
}

@BindingAdapter("app:toggleProgressState")
fun <T> ProgressBar.toggleProgressState(state: ApiState<T>?) {
    visibility = if (state is ApiState.Loading) View.VISIBLE else View.GONE
}
