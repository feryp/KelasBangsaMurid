package com.kelasbangsa.murid.ui.metodePembayaran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.MetodeBankAdapter
import com.kelasbangsa.murid.data.model.MetodeBank

class MetodePembayaranActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvMetodeBank : RecyclerView
    private lateinit var metodeBank : MutableList<MetodeBank>
    private lateinit var adapterMetodeBank : MetodeBankAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_pembayaran)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        rvMetodeBank = findViewById(R.id.rv_metode_bank)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        //List Metode Bank
        metodeBank = ArrayList()
        metodeBank.add(MetodeBank(R.drawable.ic_bank_bca, "Transfer Bank BCA"))
        metodeBank.add(MetodeBank(R.drawable.ic_bank_mandiri, "Transfer Bank Mandiri"))

        //Set adapter
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapterMetodeBank = MetodeBankAdapter(this, metodeBank)
        rvMetodeBank.layoutManager = layoutManager
        rvMetodeBank.adapter = adapterMetodeBank
        rvMetodeBank.setHasFixedSize(true)
    }
}