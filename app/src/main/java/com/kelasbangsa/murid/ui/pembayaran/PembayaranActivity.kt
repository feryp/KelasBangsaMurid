package com.kelasbangsa.murid.ui.pembayaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.JadwalSummaryAdapter
import com.kelasbangsa.murid.data.model.JadwalSummary
import com.kelasbangsa.murid.ui.metodePembayaran.MetodePembayaranActivity
import com.kelasbangsa.murid.ui.transaksi.TransaksiPembayaranActivity

class PembayaranActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnPilihMetode : MaterialButton
    private lateinit var btnBayar : MaterialButton
    private lateinit var rvJadwalSummary : RecyclerView
    private lateinit var jadwalSummary : MutableList<JadwalSummary>
    private lateinit var adapterJadwalSummary : JadwalSummaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        btnPilihMetode = findViewById(R.id.btn_pilih_metode)
        btnBayar = findViewById(R.id.btn_bayar)
        rvJadwalSummary = findViewById(R.id.rv_jadwal_summary)


        //List jadwal summary
        jadwalSummary = ArrayList()
        jadwalSummary.add(JadwalSummary("28 Juli 2021","08:00 AM","12:00 AM"))
        jadwalSummary.add(JadwalSummary("01 Agustus 2021","08:00 AM","12:00 AM"))

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterJadwalSummary = JadwalSummaryAdapter(this, jadwalSummary)
        rvJadwalSummary.layoutManager = layoutManager
        rvJadwalSummary.adapter = adapterJadwalSummary
        rvJadwalSummary.setHasFixedSize(true)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        //Set OnClick Listener
        btnPilihMetode.setOnClickListener(this)
        btnBayar.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_pilih_metode -> {
                val pilihMetode = Intent(this, MetodePembayaranActivity::class.java)
                startActivity(pilihMetode)
            }

            R.id.btn_bayar -> {
                val bayar = Intent(this, TransaksiPembayaranActivity::class.java)
                startActivity(bayar)
            }
        }
    }
}