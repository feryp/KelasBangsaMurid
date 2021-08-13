package com.kelasbangsa.murid.ui.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.BidangStudiAdapter
import com.kelasbangsa.murid.data.model.BidangStudi
import com.kelasbangsa.murid.ui.pesanKelas.PesanKelasActivity

class KategoriOlahragaActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var toolbar : MaterialToolbar

    var bidangStudi : MutableList<BidangStudi> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_olahraga)

        //INIT VIEW
        rvBidangStudi = findViewById(R.id.rv_kategori_olahraga)
        toolbar = findViewById(R.id.toolbar_olahraga)

        //List Bidang Studi
        bidangStudi.add(BidangStudi(R.drawable.im_ol_badminton,"Badminton"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_tennis,"Tenis"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_taekwondo,"Taekwondo"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_swimming,"Berenang"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_yoga,"Yoga"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_golf,"Golf"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_diving,"Diving"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_basket,"Basket"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_wushu,"Wushu"))
        bidangStudi.add(BidangStudi(R.drawable.im_ol_muay_thai,"Muay Thai"))


        //set adapter
        val layoutManager = GridLayoutManager(this, 2)
        val adapterBidangStudi = BidangStudiAdapter(bidangStudi,this)
        rvBidangStudi.layoutManager = layoutManager
        rvBidangStudi.adapter = adapterBidangStudi
        rvBidangStudi.setHasFixedSize(true)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+bidangStudi[position].namaMapel, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, PesanKelasActivity::class.java)
        intent.putExtra("nama", bidangStudi[position].namaMapel)
        startActivity(intent)
    }

}