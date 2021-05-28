package com.kelasbangsa.murid.data.repository

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqSignUp
import com.kelasbangsa.murid.data.model.ReqVerification
import com.kelasbangsa.murid.data.source.AuthDataSource
import io.reactivex.rxjava3.core.Single

class AuthRepository(private val remoteRepository: AuthDataSource) : AuthDataSource {
    override fun signIn(reqSignIn: ReqSignIn): Single<BaseStatus> {
        return remoteRepository.signIn(reqSignIn)
    }

    override fun signUp(reqSignUp: ReqSignUp): Single<BaseStatus> {
        return remoteRepository.signUp(reqSignUp)
    }

    override fun verify(reqVerification: ReqVerification): Single<BaseStatus> {
        return remoteRepository.verify(reqVerification)
    }
}