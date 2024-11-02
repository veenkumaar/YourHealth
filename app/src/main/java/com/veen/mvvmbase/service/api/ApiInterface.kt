package com.veen.mvvmbase.service.api

import com.veen.mvvmbase.model.CommonResponse
import com.veen.mvvmbase.model.login.LoginReq
import com.veen.mvvmbase.utils.CommonUtils.LOGIN
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    /*    @POST(Login_api)
        suspend fun login(@Body loginReq: LoginReq): Response<LoginRes>*/

    /*    @POST(Meeting_api)
        suspend fun meeting(
            @Header("Authorization") token: String,
            @Body meetingReq: MeetingReq
        ): Response<MeetingRes>*/

    @POST(LOGIN)
    suspend fun getLogin(@Body loginReq: LoginReq): Response<CommonResponse>
}