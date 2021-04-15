package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.google.android.material.button.MaterialButton

class LupaSandiActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack : ImageButton
    private lateinit var btnKirim : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnKirim = findViewById(R.id.btn_kirim_email)

        //Set OnClick Listener
        btnBack.setOnClickListener(this)
        btnKirim.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_back -> {
                finish()
            }

            R.id.btn_kirim_email -> {
                val kirimEmail = Intent(this, VerifikasiLupaSandiActivity::class.java)
                startActivity(kirimEmail)
            }
        }
    }
}