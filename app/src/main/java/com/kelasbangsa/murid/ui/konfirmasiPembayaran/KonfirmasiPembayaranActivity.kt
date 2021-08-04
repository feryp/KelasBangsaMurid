package com.kelasbangsa.murid.ui.konfirmasiPembayaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.transaksi.BuktiSebelumKonfirmActivity

class KonfirmasiPembayaranActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnBuktiTransaksi : MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        btnBuktiTransaksi = findViewById(R.id.btn_bukti_transaksi)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        btnBuktiTransaksi.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_bukti_transaksi -> {
                val buktiTransaksi = Intent(this, BuktiSebelumKonfirmActivity::class.java)
                startActivity(buktiTransaksi)
            }

        }
    }
}