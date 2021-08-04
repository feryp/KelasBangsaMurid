package com.kelasbangsa.murid.ui.transaksi

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
import com.kelasbangsa.murid.ui.konfirmasiPembayaran.KonfirmasiPembayaranActivity

class BuktiSebelumKonfirmActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnKonfirmasi : MaterialButton
    private lateinit var rvJadwalKonfirmasi : RecyclerView
    private lateinit var jadwalKonfirmasi : MutableList<JadwalSummary>
    private lateinit var adapterJadwalKonfirmasi : JadwalSummaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bukti_sebelum_konfirm)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi_transaksi)
        rvJadwalKonfirmasi = findViewById(R.id.rv_jadwal_konfirmasi_transaksi)

        //List jadwal summary
        jadwalKonfirmasi = ArrayList()
        jadwalKonfirmasi.add(JadwalSummary("28 Juli 2021","08:00 AM","12:00 AM"))
        jadwalKonfirmasi.add(JadwalSummary("01 Agustus 2021","08:00 AM","12:00 AM"))

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterJadwalKonfirmasi = JadwalSummaryAdapter(this, jadwalKonfirmasi)
        rvJadwalKonfirmasi.layoutManager = layoutManager
        rvJadwalKonfirmasi.adapter = adapterJadwalKonfirmasi
        rvJadwalKonfirmasi.setHasFixedSize(true)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        //Set On Click Listener
        btnKonfirmasi.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_konfirmasi_transaksi -> {
                val konfirmasi = Intent(this, KonfirmasiPembayaranActivity::class.java)
                startActivity(konfirmasi)
            }

        }
    }
}