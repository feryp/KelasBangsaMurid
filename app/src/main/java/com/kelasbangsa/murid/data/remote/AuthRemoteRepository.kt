package com.kelasbangsa.murid.data.remote

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqSignUp
import com.kelasbangsa.murid.data.model.ReqVerification
import com.kelasbangsa.murid.data.network.ApiService
import com.kelasbangsa.murid.data.source.AuthDataSource
import io.reactivex.rxjava3.core.Single

class AuthRemoteRepository(private val apiService: ApiService) : AuthDataSource {
    override fun signIn(reqSignIn: ReqSignIn): Single<BaseStatus> {
        return apiService.signIn(reqSignIn)
    }

    override fun signUp(reqSignUp: ReqSignUp): Single<BaseStatus> {
        return apiService.signUp(reqSignUp)
    }

    override fun verify(reqVerification: ReqVerification): Single<BaseStatus> {
        return apiService.verify(reqVerification)
    }
}