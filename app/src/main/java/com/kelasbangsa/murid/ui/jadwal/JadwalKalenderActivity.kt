package com.kelasbangsa.murid.ui.jadwal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.KetersediaanAdapter
import com.kelasbangsa.murid.adapter.KetersediaanJamAdapter
import com.kelasbangsa.murid.adapter.ListMuridPesanAdapter
import com.kelasbangsa.murid.data.model.KetersediaanJam
import com.kelasbangsa.murid.data.model.ListMurid

class JadwalKalenderActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var calendaerView : CalendarView
    private lateinit var rvKetersediaanJam : RecyclerView
    private lateinit var rvJadwalDipesan : RecyclerView
    private lateinit var ketersediaanJam : MutableList<KetersediaanJam>
    private lateinit var adapterKetersediaan : KetersediaanJamAdapter
    private lateinit var jadwalDipesan : MutableList<ListMurid>
    private lateinit var adapterJadwal : ListMuridPesanAdapter
    private lateinit var tvTglDipilih : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_kalender)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pilih_jadwal)
        rvKetersediaanJam = findViewById(R.id.rv_ketersediaan_jam_guru)
        rvJadwalDipesan = findViewById(R.id.rv_jadwal_dipesan_murid)
        calendaerView = findViewById(R.id.calendar_view)
        tvTglDipilih = findViewById(R.id.tv_tgl_dipilih)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        calendaerView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            tvTglDipilih.text = "$dayOfMonth/$month/$year"
        }
        //set monday first day
        calendaerView.firstDayOfWeek = 2

        //List Ketersediaan
        ketersediaanJam = ArrayList()
        ketersediaanJam.add(KetersediaanJam("08:00 AM","12:00 AM"))
        ketersediaanJam.add(KetersediaanJam("16:00 PM","18:00 PM"))
        ketersediaanJam.add(KetersediaanJam("19:00 PM","21:00 PM"))

        //Set adapter
        val layoutManagerKetersediaan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterKetersediaan = KetersediaanJamAdapter(ketersediaanJam)
        rvKetersediaanJam.adapter = adapterKetersediaan
        rvKetersediaanJam.layoutManager = layoutManagerKetersediaan
        rvKetersediaanJam.setHasFixedSize(true)

        //List Jadwal dipesan
        jadwalDipesan = ArrayList()
        for (i : Int in 1..8)
            jadwalDipesan.add(ListMurid(
                R.drawable.foto_example,
            "07 September 2021",
            "10:30 AM",
            "12:00 AM",
            "Kedoya Selatan, Jakarta",
            "Telah Dipesan"))

        //Set adapter
        val layoutManagerJadwal = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterJadwal = ListMuridPesanAdapter(jadwalDipesan)
        rvJadwalDipesan.adapter = adapterJadwal
        rvJadwalDipesan.layoutManager = layoutManagerJadwal
        rvJadwalDipesan.setHasFixedSize(true)



    }
}