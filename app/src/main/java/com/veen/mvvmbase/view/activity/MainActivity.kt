package com.veen.mvvmbase.view.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.veen.mvvmbase.R
import com.veen.mvvmbase.base.BaseActivity
import com.veen.mvvmbase.databinding.ActivityMainBinding
import com.veen.mvvmbase.service.api.NetworkResult
import com.veen.mvvmbase.utils.CommonUtils.TAG
import com.veen.mvvmbase.utils.CustomLoader
import com.veen.mvvmbase.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    val viewModel by viewModels<MainViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onViewBindingCreated(savedInstanceState: Bundle?) {
        super.onViewBindingCreated(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //todo rest of code here
        fetchdata()
    }

    private fun fetchdata() {
        viewModel.fetchLoginResponse()
        viewModel.response.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    Log.d(TAG, "fetchdata: ${it.data}")
                }

                is NetworkResult.Error -> {
                    Log.d(TAG, "fetchdata: ${it.data}")
                }

                is NetworkResult.Loading -> {
                    CustomLoader.showLoader(this)
                }
            }
        }
    }
}