package com.kelasbangsa.murid.ui.transaksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.JadwalSummaryAdapter
import com.kelasbangsa.murid.data.model.JadwalSummary

class DetailTransaksiSelesaiActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvJadwalDetail : RecyclerView
    private lateinit var jadwalDetail : MutableList<JadwalSummary>
    private lateinit var adapterJadwalDetail : JadwalSummaryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_transaksi_selesai)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_transaksi_selesai)
        rvJadwalDetail = findViewById(R.id.rv_jadwal_detail_transaksi_selesai)

        //List jadwal summary
        jadwalDetail = ArrayList()
        jadwalDetail.add(JadwalSummary("28 Juli 2021","08:00 AM","12:00 AM"))
        jadwalDetail.add(JadwalSummary("01 Agustus 2021","08:00 AM","12:00 AM"))

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterJadwalDetail = JadwalSummaryAdapter(this, jadwalDetail)
        rvJadwalDetail.layoutManager = layoutManager
        rvJadwalDetail.adapter = adapterJadwalDetail
        rvJadwalDetail.setHasFixedSize(true)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }
}