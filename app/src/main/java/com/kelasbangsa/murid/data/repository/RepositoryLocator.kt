package com.kelasbangsa.murid.data.repository

import com.example.rentagown.v2.data.remote.RemoteRepositoryLocator

class RepositoryLocator(remoteLocator: RemoteRepositoryLocator) : IRepositoryLocator {

    companion object {
        @Volatile private var INSTANCE: RepositoryLocator? = null

        fun getInstance(remoteLocator: RemoteRepositoryLocator): RepositoryLocator {
            if(INSTANCE == null) {
                INSTANCE = RepositoryLocator(remoteLocator)
            }
            return INSTANCE!!
        }

    }

    override val authRepository: AuthRepository by lazy {
        AuthRepository(remoteLocator.authRemoteRepository)
    }

}