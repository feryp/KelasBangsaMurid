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

class KategoriOlahragaActivity : AppCompatActivity(), OnItemClickListener, View.OnClickListener {

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var btnBack : ImageButton

    var bidangStudi : MutableList<BidangStudi> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_olahraga)

        //INIT VIEW
        rvBidangStudi = findViewById(R.id.rv_kategori_olahraga)
        btnBack = findViewById(R.id.btn_back)

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