package com.kelasbangsa.murid.data.network

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqSignUp
import com.kelasbangsa.murid.data.model.ReqVerification
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    //Sign in
    @POST(Url.LOGIN_URL)
    fun signIn(@Body reqSignIn: ReqSignIn): Single<BaseStatus>

    //Sign up
    @POST(Url.SIGNUP_URL)
    fun signUp(@Body reqSignUp: ReqSignUp): Single<BaseStatus>

    //Verify OTP
    @POST(Url.VERIFY_URL)
    fun verify(@Body reqVerification: ReqVerification): Single<BaseStatus>
}