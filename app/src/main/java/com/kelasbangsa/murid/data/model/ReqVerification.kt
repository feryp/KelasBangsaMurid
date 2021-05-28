package com.kelasbangsa.murid.data.model

import com.google.gson.annotations.SerializedName

data class ReqVerification(

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("id_fcm")
	val idFcm: String? = null,

	@field:SerializedName("otp")
	val otp: String? = null
)
