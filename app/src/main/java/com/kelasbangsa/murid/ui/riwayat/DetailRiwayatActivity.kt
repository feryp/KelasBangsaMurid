package com.kelasbangsa.murid.ui.riwayat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.konfirmasiPembayaran.KonfirmasiPembayaranActivity
import com.kelasbangsa.murid.ui.ulasan.BeriUlasanActivity

class DetailRiwayatActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var beriUlasan : MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_riwayat)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_detail_riwayat)
        beriUlasan = findViewById(R.id.menu_beri_komentar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set Listener
        beriUlasan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.menu_beri_komentar -> {
                val beriUlasan = Intent(this, BeriUlasanActivity::class.java)
                startActivity(beriUlasan)
            }

        }
    }
}