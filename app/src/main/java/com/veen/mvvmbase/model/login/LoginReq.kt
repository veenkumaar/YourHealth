package com.veen.mvvmbase.model.login

data class LoginReq(
    val dateOfBirth: String,
    val deviceId: String,
    val fullName: String,
    val mobile: String,
    val timeStamp: String
)