package com.example.rentagown.v2.data.remote

import com.kelasbangsa.murid.data.network.ApiService
import com.kelasbangsa.murid.data.remote.AuthRemoteRepository

class RemoteRepositoryLocator(service: ApiService) : IRemoteServiceLocator {

    companion object {
        @Volatile private var INSTANCE: RemoteRepositoryLocator? = null

        fun getInstance(service: ApiService): RemoteRepositoryLocator {
            if(INSTANCE == null) {
                INSTANCE = RemoteRepositoryLocator(service)
            }
            return INSTANCE!!
        }

    }

    override val authRemoteRepository: AuthRemoteRepository by lazy {
        AuthRemoteRepository(service)
    }

}