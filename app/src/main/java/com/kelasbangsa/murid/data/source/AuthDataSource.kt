package com.kelasbangsa.murid.data.source

import com.kelasbangsa.murid.data.model.*
import io.reactivex.rxjava3.core.Single

interface AuthDataSource {

    fun signIn(reqLogin: ReqLogin): Single<BaseStatus>
    fun signUp(reqDaftar: ReqDaftar): Single<BaseStatus>
    fun verify(reqVerifikasi: ReqVerifikasi): Single<BaseStatus>

}