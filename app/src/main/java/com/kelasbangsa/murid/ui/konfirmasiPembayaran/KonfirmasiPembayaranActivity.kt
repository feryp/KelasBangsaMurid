package com.kelasbangsa.murid.ui.konfirmasiPembayaran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R

class KonfirmasiPembayaranActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }
}