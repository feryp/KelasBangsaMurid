package com.kelasbangsa.murid.ui.pesanKelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.pembayaran.PembayaranActivity

class PesanKelasPaketActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnPilihAlamat : MaterialButton
    private lateinit var btnGantiAlamat : MaterialButton
    private lateinit var btnUbah : MaterialButton
    private lateinit var btnHapus : MaterialButton
    private lateinit var btnAturJadwal : MaterialButton
    private lateinit var btnTambahJadwal : MaterialButton
    private lateinit var btnPesan : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_kelas_paket)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pesan_kelas_paket)
        btnPilihAlamat = findViewById(R.id.btn_pilih_alamat)
        btnGantiAlamat = findViewById(R.id.btn_ganti_alamat)
        btnUbah = findViewById(R.id.btn_ubah_paket)
        btnHapus = findViewById(R.id.btn_hapus_paket)
        btnAturJadwal = findViewById(R.id.btn_atur_jadwal_paket)
        btnTambahJadwal = findViewById(R.id.btn_tambah_jadwal_paket)
        btnPesan = findViewById(R.id.btn_pesan_paket)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set Listener
        btnPilihAlamat.setOnClickListener(this)
        btnGantiAlamat.setOnClickListener(this)
        btnUbah.setOnClickListener(this)
        btnHapus.setOnClickListener(this)
        btnAturJadwal.setOnClickListener(this)
        btnTambahJadwal.setOnClickListener(this)
        btnPesan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_pesan_paket -> {
            val pesanPaket = Intent(this, PembayaranActivity::class.java)
            startActivity(pesanPaket)
        }
        }
    }
}