package com.veen.mvvmbase.service.api

import com.veen.mvvmbase.base.BaseApiResponse
import com.veen.mvvmbase.model.CommonResponse
import com.veen.mvvmbase.model.login.LoginReq
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getLogin(loginReq: LoginReq): Flow<NetworkResult<CommonResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getLogin(loginReq) })
        }.flowOn(Dispatchers.IO)
    }
}