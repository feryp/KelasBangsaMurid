package com.kelasbangsa.murid.ui.lupaSandiVerifikasi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.goodiebag.pinview.Pinview
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.sandiBaru.SandiBaruActivity

class LupaSandiVerifikasiActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnKirimKode : MaterialButton
    private lateinit var btnVerifikasi : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi_verifikasi)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_lupa_sandi_verifikasi)
        btnKirimKode = findViewById(R.id.btn_kirim_ulang_kode)
        btnVerifikasi = findViewById(R.id.btn_verifikasi)

        //Set OnClick Listener
        btnVerifikasi.setOnClickListener(this)
        btnKirimKode.setOnClickListener(this)

        initializeWidgets()

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
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