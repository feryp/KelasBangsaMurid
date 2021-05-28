package com.kelasbangsa.murid.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)