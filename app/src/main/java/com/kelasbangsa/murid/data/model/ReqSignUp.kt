package com.kelasbangsa.murid.data.model

import com.google.gson.annotations.SerializedName

data class ReqSignUp(

	@field:SerializedName("nama")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("password")
	val password: String? = null
)
