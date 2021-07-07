package com.kelasbangsa.murid.data.model

import java.util.*

data class PaketBelajar (
    var namaPaket : String,
    var kategoriPaket : String,
    var bidangStudiPaket : String,
    var tingkatPendidikanPaket : String,
    var tingkatKelasPaket : String,
    val jmlPertemuan : String,
    var tanggalPaket : String,
    var jamMulaiPaket : String,
    var jamSelesaiPaket : String,
    var jmlMinPesertaPaket : Int,
    var jmlMaxPesertaPaket : Int,
    var fotoGuru : Int,
    var namaGuru : String,
    var alamatPaket : String,
    var hargaPaket : String


)