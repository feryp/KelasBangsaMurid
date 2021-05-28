package com.kelasbangsa.murid.data.model

import com.google.gson.annotations.SerializedName

data class AuthLogin(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("refresh_token")
	val refreshToken: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)
