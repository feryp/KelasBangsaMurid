package com.kelasbangsa.murid

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.goodiebag.pinview.Pinview
import com.google.android.material.button.MaterialButton

class VerificationForgotPasswordActivity : AppCompatActivity() {

    var btnBack : ImageButton? = null
    var btnKirimKode : MaterialButton? = null
    var btnVerifikasi : MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_forgot_password)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnKirimKode = findViewById(R.id.btn_kirim_ulang_kode)
        btnVerifikasi = findViewById(R.id.btn_verifikasi)

        //Set OnClick Listener
        btnBack?.setOnClickListener {
            finish()
        }

        btnVerifikasi?.setOnClickListener {
            val verifikasi = Intent(this, NewPasswordActivity::class.java)
            startActivity(verifikasi)
        }

        btnKirimKode?.setOnClickListener {
            //belum ada kode
        }

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
}