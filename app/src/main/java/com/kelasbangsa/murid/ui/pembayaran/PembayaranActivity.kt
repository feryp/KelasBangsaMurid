package com.kelasbangsa.murid.ui.pembayaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.metodePembayaran.MetodePembayaranActivity

class PembayaranActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnPilihMetode : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        btnPilihMetode = findViewById(R.id.btn_pilih_metode)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        //Set OnClick Listener
        btnPilihMetode.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_pilih_metode -> {
                val pilihMetode = Intent(this, MetodePembayaranActivity::class.java)
                startActivity(pilihMetode)
            }
        }
    }
}