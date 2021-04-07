package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.button.MaterialButton

class ForgotPasswordActivity : AppCompatActivity() {

    var btnBack : ImageButton? = null
    var btnKirim : MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnKirim = findViewById(R.id.btn_kirim_email)

        //Set OnClick Listener
        btnBack?.setOnClickListener {
            finish()
        }

        btnKirim?.setOnClickListener {
            val kirimEmail = Intent(this, VerificationForgotPasswordActivity::class.java)
            startActivity(kirimEmail)
        }
    }
}