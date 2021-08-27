package com.kelasbangsa.murid.data.model

open class ListItemJadwal (
    val type : Int
) {
    companion object {
        const val TYPE_DATE = 0
        const val TYPE_GENERAL = 1
    }
}