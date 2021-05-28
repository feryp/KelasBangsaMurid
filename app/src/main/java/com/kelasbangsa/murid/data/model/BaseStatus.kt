package com.kelasbangsa.murid.data.model

import com.google.gson.annotations.SerializedName

data class BaseStatus (

    @SerializedName("ok")
    val ok: Boolean? = false,

    @SerializedName("status")
    val status: String? = "",

    @SerializedName("code")
    val code: Int? = null
)