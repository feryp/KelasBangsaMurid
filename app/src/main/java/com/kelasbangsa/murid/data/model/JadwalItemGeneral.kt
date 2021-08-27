package com.kelasbangsa.murid.data.model

class JadwalItemGeneral (
    val katagori : String,
    val bidangStudi : String,
    val tingKelas : String,
    val jamMulai : String,
    val jamSelesai : String,
    val jumlahPeserta : String,
    val namaGuru : String,
    val fotoGuru : Int,
) : ListItemJadwal(TYPE_GENERAL)