package com.kelasbangsa.murid.data.repository

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqLogin
import com.kelasbangsa.murid.data.model.ReqDaftar
import com.kelasbangsa.murid.data.model.ReqVerifikasi
import com.kelasbangsa.murid.data.source.AuthDataSource
import io.reactivex.rxjava3.core.Single

class AuthRepository(private val remoteRepository: AuthDataSource) : AuthDataSource {
    override fun signIn(reqLogin: ReqLogin): Single<BaseStatus> {
        return remoteRepository.signIn(reqLogin)
    }

    override fun signUp(reqDaftar: ReqDaftar): Single<BaseStatus> {
        return remoteRepository.signUp(reqDaftar)
    }

    override fun verify(reqVerifikasi: ReqVerifikasi): Single<BaseStatus> {
        return remoteRepository.verify(reqVerifikasi)
    }
}