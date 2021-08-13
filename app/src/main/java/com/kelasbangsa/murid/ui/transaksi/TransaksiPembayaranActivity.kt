package com.kelasbangsa.murid.ui.transaksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.iwgang.countdownview.CountdownView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.JadwalSummaryAdapter
import com.kelasbangsa.murid.data.model.JadwalSummary
import com.kelasbangsa.murid.ui.konfirmasiPembayaran.KonfirmasiPembayaranActivity

class TransaksiPembayaranActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var countdownView: CountdownView
    private lateinit var rvJadwalDetailTransaksi : RecyclerView
    private lateinit var jadwalSummary : MutableList<JadwalSummary>
    private lateinit var adapterJadwalSummary : JadwalSummaryAdapter
    private lateinit var btnSudahBayar : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_transaksi_pembayaran)
        countdownView = findViewById(R.id.countdown_view)
        rvJadwalDetailTransaksi = findViewById(R.id.rv_jadwal_detail_transaksi)
        btnSudahBayar = findViewById(R.id.btn_sudah_transfer)


        //List jadwal summary
        jadwalSummary = ArrayList()
        jadwalSummary.add(JadwalSummary("28 Juli 2021","08:00 AM","12:00 AM"))
        jadwalSummary.add(JadwalSummary("01 Agustus 2021","08:00 AM","12:00 AM"))

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterJadwalSummary = JadwalSummaryAdapter(this, jadwalSummary)
        rvJadwalDetailTransaksi.layoutManager = layoutManager
        rvJadwalDetailTransaksi.adapter = adapterJadwalSummary
        rvJadwalDetailTransaksi.setHasFixedSize(true)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        //Set On Click Listener
        btnSudahBayar.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_sudah_transfer -> {
                val sudahBayar = Intent(this, KonfirmasiPembayaranActivity::class.java)
                startActivity(sudahBayar)
            }

        }
    }

}

