package com.veen.mvvmbase.service.api

import com.veen.mvvmbase.model.login.LoginReq
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getLogin(loginReq: LoginReq) =
        apiInterface.getLogin(loginReq)
}