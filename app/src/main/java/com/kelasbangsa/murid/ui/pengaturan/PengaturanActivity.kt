package com.kelasbangsa.murid.ui.pengaturan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.pin.AturPinActivity
import com.kelasbangsa.murid.ui.sandiBaru.GantiKataSandiActivity

class PengaturanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var menuGantiSandi : RelativeLayout
    private lateinit var menuPinKB : RelativeLayout
    private lateinit var pushNotifikasi : SwitchCompat
    private lateinit var emailNotifikasi : SwitchCompat
    private lateinit var menuTentangKB : RelativeLayout
    private lateinit var menuPusatBantuan : RelativeLayout
    private lateinit var menuSyaratKetentuan : RelativeLayout
    private lateinit var menuKebijakanPribadi : RelativeLayout
    private lateinit var menuReviewAplikasi : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pengaturan)
        menuGantiSandi = findViewById(R.id.menu_ganti_sandi)
        menuPinKB = findViewById(R.id.menu_pin_kb)
        pushNotifikasi = findViewById(R.id.toogle_switch_push_notifikasi)
        emailNotifikasi = findViewById(R.id.toogle_switch_email_notifikasi)
        menuTentangKB = findViewById(R.id.menu_tentang_kb)
        menuPusatBantuan = findViewById(R.id.menu_pusat_bantuan)
        menuSyaratKetentuan = findViewById(R.id.menu_syarat_dan_ketentuan)
        menuKebijakanPribadi = findViewById(R.id.menu_kebijakan_pribadi)
        menuReviewAplikasi = findViewById(R.id.menu_review_aplikasi)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set listener
        menuGantiSandi.setOnClickListener(this)
        menuPinKB.setOnClickListener(this)
        menuTentangKB.setOnClickListener(this)
        menuPusatBantuan.setOnClickListener(this)
        menuSyaratKetentuan.setOnClickListener(this)
        menuKebijakanPribadi.setOnClickListener(this)
        menuReviewAplikasi.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.menu_ganti_sandi -> {
                val gantiSandi = Intent(this, GantiKataSandiActivity::class.java)
                startActivity(gantiSandi)
            }

            R.id.menu_pin_kb -> {
                val aturPIN = Intent (this, AturPinActivity::class.java)
                startActivity(aturPIN)
            }
        }
    }
}