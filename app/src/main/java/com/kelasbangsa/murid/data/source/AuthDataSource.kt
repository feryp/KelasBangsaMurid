package com.kelasbangsa.murid.data.source

import com.kelasbangsa.murid.data.model.*
import io.reactivex.rxjava3.core.Single

interface AuthDataSource {

    fun signIn(reqSignIn: ReqSignIn): Single<BaseStatus>
    fun signUp(reqSignUp: ReqSignUp): Single<BaseStatus>
    fun verify(reqVerification: ReqVerification): Single<BaseStatus>

}