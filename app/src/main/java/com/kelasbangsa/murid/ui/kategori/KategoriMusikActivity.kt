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

class KategoriMusikActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var toolbar : MaterialToolbar

    var bidangStudi : MutableList<BidangStudi> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_musik)

        //INIT VIEW
        rvBidangStudi = findViewById(R.id.rv_kategori_musik)
        toolbar = findViewById(R.id.toolbar_musik)

        //List Bidang Studi
        bidangStudi.add(BidangStudi(R.drawable.im_ms_piano,"Piano"))
        bidangStudi.add(BidangStudi(R.drawable.im_ms_guitar,"Gitar"))
        bidangStudi.add(BidangStudi(R.drawable.im_ms_bass,"Bass"))
        bidangStudi.add(BidangStudi(R.drawable.im_ms_drum,"Drum"))
        bidangStudi.add(BidangStudi(R.drawable.im_ms_violin,"Violin"))

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