package com.kelasbangsa.murid.ui.paketBelajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.guru.GaleriActivity
import com.kelasbangsa.murid.ui.guru.ProfileGuruActivity
import com.kelasbangsa.murid.ui.pesanKelas.PesanKelasPaketActivity

class DetailPaketActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnLihatProfil : MaterialButton
    private lateinit var btnTanyaGuru : MaterialButton
    private lateinit var btnPilihPaket : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_paket)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_detail_paket)
        btnLihatProfil = findViewById(R.id.btn_lihat_profil)
        btnTanyaGuru = findViewById(R.id.btn_tanya_guru)
        btnPilihPaket = findViewById(R.id.btn_pilih_paket_detail)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set listener
        btnLihatProfil.setOnClickListener(this)
        btnTanyaGuru.setOnClickListener(this)
        btnPilihPaket.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_lihat_profil -> {
                val lihatProfil = Intent(this, ProfileGuruActivity::class.java)
                startActivity(lihatProfil)
            }

            R.id.btn_pilih_paket_detail -> {
                val paketBelajar = Intent(this, PesanKelasPaketActivity::class.java)
                startActivity(paketBelajar)
            }

        }
    }
}