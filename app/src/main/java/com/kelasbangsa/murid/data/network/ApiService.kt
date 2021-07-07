package com.kelasbangsa.murid.data.network

import com.kelasbangsa.murid.data.model.BaseStatus
import com.kelasbangsa.murid.data.model.ReqLogin
import com.kelasbangsa.murid.data.model.ReqDaftar
import com.kelasbangsa.murid.data.model.ReqVerifikasi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    //Sign in
    @POST(Url.LOGIN_URL)
    fun signIn(@Body reqLogin: ReqLogin): Single<BaseStatus>

    //Sign up
    @POST(Url.SIGNUP_URL)
    fun signUp(@Body reqDaftar: ReqDaftar): Single<BaseStatus>

    //Verify OTP
    @POST(Url.VERIFY_URL)
    fun verify(@Body reqVerifikasi: ReqVerifikasi): Single<BaseStatus>
}