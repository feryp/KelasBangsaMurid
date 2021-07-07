package com.kelasbangsa.murid.data.remote

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqLogin
import com.kelasbangsa.murid.data.model.ReqDaftar
import com.kelasbangsa.murid.data.model.ReqVerifikasi
import com.kelasbangsa.murid.data.network.ApiService
import com.kelasbangsa.murid.data.source.AuthDataSource
import io.reactivex.rxjava3.core.Single

class AuthRemoteRepository(private val apiService: ApiService) : AuthDataSource {
    override fun signIn(reqLogin: ReqLogin): Single<BaseStatus> {
        return apiService.signIn(reqLogin)
    }

    override fun signUp(reqDaftar: ReqDaftar): Single<BaseStatus> {
        return apiService.signUp(reqDaftar)
    }

    override fun verify(reqVerifikasi: ReqVerifikasi): Single<BaseStatus> {
        return apiService.verify(reqVerifikasi)
    }
}