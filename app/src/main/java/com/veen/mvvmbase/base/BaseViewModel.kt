package com.veen.mvvmbase.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.veen.mvvmbase.service.api.NetworkResult

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private val apiResponse = MutableLiveData<NetworkResult<Any>>()
    val _apiResponse: LiveData<NetworkResult<Any>> = apiResponse
}