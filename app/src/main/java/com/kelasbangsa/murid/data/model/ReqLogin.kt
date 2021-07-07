package com.kelasbangsa.murid.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ReqLogin(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(password)
		parcel.writeString(email)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ReqLogin> {
		override fun createFromParcel(parcel: Parcel): ReqLogin {
			return ReqLogin(parcel)
		}

		override fun newArray(size: Int): Array<ReqLogin?> {
			return arrayOfNulls(size)
		}
	}
}
