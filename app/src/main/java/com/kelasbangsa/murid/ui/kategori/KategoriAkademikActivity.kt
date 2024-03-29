package com.kelasbangsa.murid.ui.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.BidangStudiAdapter
import com.kelasbangsa.murid.data.model.BidangStudi
import com.kelasbangsa.murid.ui.pesanKelas.PesanKelasActivity

class KategoriAkademikActivity : AppCompatActivity(), OnItemClickListener{

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var toolbar : MaterialToolbar

    var bidangStudi : MutableList<BidangStudi> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_akademik)

        //INIT VIEW
        rvBidangStudi = findViewById(R.id.rv_kategori_akademik)
        toolbar = findViewById(R.id.toolbar_akademik)

        //List Bidang Studi
        bidangStudi.add(BidangStudi(R.drawable.im_ak_ekonomi,"Ekonomi"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_geografi,"Geografi"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_kimia,"Kimia"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_biologi,"Biologi"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_fisika,"Fisika"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_matematika,"Matematika"))
        bidangStudi.add(BidangStudi(R.drawable.im_ak_un,"Ujian Nasional"))


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