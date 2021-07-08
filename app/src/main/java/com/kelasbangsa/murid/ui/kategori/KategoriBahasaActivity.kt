package com.kelasbangsa.murid.ui.kategori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.BidangStudiAdapter
import com.kelasbangsa.murid.data.model.BidangStudi

class KategoriBahasaActivity : AppCompatActivity(), OnItemClickListener, View.OnClickListener {

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var btnBack : ImageButton

    var bidangStudi : MutableList<BidangStudi> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_bahasa)

        //INIT VIEW
        rvBidangStudi = findViewById(R.id.rv_kategori_bahasa)
        btnBack = findViewById(R.id.btn_back)

        //List Bidang Studi
        bidangStudi.add(BidangStudi(R.drawable.im_bh_indonesia,"Indonesia"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_english,"Inggris"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_china,"Mandarin"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_france,"Perancis"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_jepang,"Jepang"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_jerman,"Jerman"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_korea,"Korea"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_spain,"Spanyol"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_rusia,"Rusia"))
        bidangStudi.add(BidangStudi(R.drawable.im_bh_arab,"Arab"))

        //set adapter
        val layoutManager = GridLayoutManager(this, 2)
        val adapterBidangStudi = BidangStudiAdapter(bidangStudi,this)
        rvBidangStudi.layoutManager = layoutManager
        rvBidangStudi.adapter = adapterBidangStudi
        rvBidangStudi.setHasFixedSize(true)

        //Set OnClick Listener
        btnBack.setOnClickListener(this)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+bidangStudi[position].namaMapel, Toast.LENGTH_SHORT).show()
//        val intent = Intent(this, SemuaKategoriActivity::class.java)
//        intent.putExtra("nama", bidangStudi[position].namaMapel)
//        startActivity(intent)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back ->{
                finish()
            }

        }
    }
}