package com.kelasbangsa.murid.ui.lupaSandiVerifikasi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.goodiebag.pinview.Pinview
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.sandiBaru.SandiBaruActivity

class LupaSandiVerifikasiActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack : ImageButton
    private lateinit var btnKirimKode : MaterialButton
    private lateinit var btnVerifikasi : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi_verifikasi)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnKirimKode = findViewById(R.id.btn_kirim_ulang_kode)
        btnVerifikasi = findViewById(R.id.btn_verifikasi)

        //Set OnClick Listener
        btnBack.setOnClickListener(this)
        btnVerifikasi.setOnClickListener(this)
        btnKirimKode.setOnClickListener(this)

        initializeWidgets()
    }

    private fun initializeWidgets() {
        val pinView = findViewById<Pinview>(R.id.pin_view)
        pinView.setPinViewEventListener { pinview, fromUser ->
            Toast.makeText(this, pinview.value, Toast.LENGTH_SHORT).show()
        }

        //pin customize
        pinView.setTextSize(18)
        pinView.setTextSize(Color.BLACK)
        pinView.showCursor(true)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_back -> {
                finish()
            }

            R.id.btn_verifikasi -> {
                val verifikasi = Intent(this, SandiBaruActivity::class.java)
                startActivity(verifikasi)
            }

            R.id.btn_kirim_ulang_kode -> {
                //belum ada kode
            }
        }
    }
}