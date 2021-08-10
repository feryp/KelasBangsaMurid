package com.kelasbangsa.murid.ui.tarikSaldo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.RiwayatPenarikanAdapter
import com.kelasbangsa.murid.data.model.RiwayatPenarikan

class TarikSaldoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvRiwayat : RecyclerView
    private lateinit var riwayatPenarikan : MutableList<RiwayatPenarikan>
    private lateinit var adapterRiwayat : RiwayatPenarikanAdapter
    private lateinit var btnPenarikan : MaterialButton
    val botshetPenarikan = BotSheetPenarikanFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarik_saldo)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_tariK_saldo)
        rvRiwayat = findViewById(R.id.rv_riwayat_penarikan)
        btnPenarikan = findViewById(R.id.btn_penarikan_saldo)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //List Riwayat
        riwayatPenarikan = ArrayList()
        for (i : Int in 1..200)
            riwayatPenarikan.add(
                RiwayatPenarikan(
                    "15-11-2021 10:20 WIB",
                    "+ Rp 100.000"
                )
            )

        //Set adapter riwayat
        val layoutManagerRiwayat = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterRiwayat = RiwayatPenarikanAdapter(riwayatPenarikan)
        rvRiwayat.layoutManager =  layoutManagerRiwayat
        rvRiwayat.adapter = adapterRiwayat
        rvRiwayat.setHasFixedSize(true)

        //Set OnClick Listener
        btnPenarikan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_penarikan_saldo -> {
                botshetPenarikan.show(supportFragmentManager, "BottomSheetDialog")
            }
        }
    }
}