package com.kelasbangsa.murid.ui.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.*
import com.kelasbangsa.murid.data.model.BidangStudi
import com.kelasbangsa.murid.data.model.Galeri
import com.kelasbangsa.murid.data.model.Keahlian
import com.kelasbangsa.murid.data.model.PaketBelajar
import com.kelasbangsa.murid.ui.metodePembayaran.MetodePembayaranActivity
import com.kelasbangsa.murid.ui.transaksi.TransaksiActivity

class ProfileGuruActivity : AppCompatActivity(), OnItemClickListener, View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var bidangStudi : MutableList<BidangStudi>
    private lateinit var adapterBS : SliderBSProfileGuruAdapter
    private lateinit var rvGaleri : RecyclerView
    private lateinit var galeri : MutableList<Galeri>
    private lateinit var adapterSliderGaleri : SliderGaleriAdapter
    private lateinit var rvKeahlian : RecyclerView
    private lateinit var keahlian : MutableList<Keahlian>
    private lateinit var adapterKeahlian : KeahlianAdapter
    private lateinit var rvPaketBelajar : RecyclerView
    private lateinit var paketBelajar: MutableList<PaketBelajar>
    private lateinit var adapterPaketBelajar : SliderPaketBelajarProfileAdapter
    private lateinit var btnLihatSemuaGaleri : MaterialButton
    private lateinit var btnLihatSemuaKeahlian : MaterialButton
    private lateinit var btnLihatSemuaPaket : MaterialButton
    private lateinit var btnLihatSemuaUlasan : MaterialButton
    val botSheetKeahlian = BotSheetKeahlianFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_guru)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_profile_guru)
        rvBidangStudi = findViewById(R.id.rv_bs_profile_guru)
        rvGaleri = findViewById(R.id.rv_slider_galeri_profile_guru)
        rvKeahlian = findViewById(R.id.rv_slider_keahlian_profile_guru)
        rvPaketBelajar = findViewById(R.id.rv_slider_paket_profile_guru)
        btnLihatSemuaGaleri = findViewById(R.id.btn_lihat_semua_galeri)
        btnLihatSemuaKeahlian = findViewById(R.id.btn_lihat_semua_keahlian)
        btnLihatSemuaPaket = findViewById(R.id.btn_lihat_semua_paket_profile_guru)
        btnLihatSemuaUlasan = findViewById(R.id.btn_lihat_semua_ulasan)


        toolbar.setNavigationOnClickListener {
            finish()
        }

        //List Bidang Studi
        bidangStudi = ArrayList()
        bidangStudi.add(BidangStudi(0,"Matematika"))
        bidangStudi.add(BidangStudi(0,"Memasak"))
        bidangStudi.add(BidangStudi(0,"Mengaji"))
        bidangStudi.add(BidangStudi(0,"Adobe"))
        bidangStudi.add(BidangStudi(0,"Biologi"))
        bidangStudi.add(BidangStudi(0,"Gitar"))

        //Set Adapter
        val layoutManagerBS = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterBS = SliderBSProfileGuruAdapter(bidangStudi, this)
        rvBidangStudi.adapter = adapterBS
        rvBidangStudi.layoutManager = layoutManagerBS
        rvBidangStudi.setHasFixedSize(true)
//        adapterBS.selectCategory(0)

        //List Galeri
        galeri = ArrayList()
        for (i : Int in 1..10)
            galeri.add(Galeri(R.drawable.foto_example))

        //Set adapter
        val layoutManagerGaleri = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterSliderGaleri = SliderGaleriAdapter(galeri, this)
        rvGaleri.adapter = adapterSliderGaleri
        rvGaleri.layoutManager = layoutManagerGaleri
        rvGaleri.setHasFixedSize(true)

        //List Keahlian
        keahlian = ArrayList()
        keahlian.add(Keahlian("Aljabar Linier"))
        keahlian.add(Keahlian("Geometri"))
        keahlian.add(Keahlian("Peluang"))
        keahlian.add(Keahlian("Aritmetika"))
        keahlian.add(Keahlian("Trigonometri"))
        keahlian.add(Keahlian("Adobe XD"))
        keahlian.add(Keahlian("Adobe Photoshop"))

        //Set adapter
        val layoutManagerKeahlian = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterKeahlian = KeahlianAdapter(keahlian)
        rvKeahlian.adapter = adapterKeahlian
        rvKeahlian.layoutManager = layoutManagerKeahlian
        rvKeahlian.setHasFixedSize(true)

        //List Paket
        paketBelajar = ArrayList()
        for (i : Int in 1..10)
            paketBelajar.add(
                PaketBelajar(
                    "Paket Matematika Dua",
                    "",
                    "",
                    "SMA",
                    "Kelas 10",
                    "2 Pertemuan",
                    "",
                    "",
                    "",
                    0,
                    0,
                    0,
                    "",
                    "",
                    "Rp 40.000"

                )
            )

        //Set adapter
        val layoutManagerPaket = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPaketBelajar = SliderPaketBelajarProfileAdapter(paketBelajar,this)
        rvPaketBelajar.adapter = adapterPaketBelajar
        rvPaketBelajar.layoutManager = layoutManagerPaket
        rvPaketBelajar.setHasFixedSize(true)

        //Set OnClick Listener
        btnLihatSemuaGaleri.setOnClickListener(this)
        btnLihatSemuaKeahlian.setOnClickListener(this)
        btnLihatSemuaPaket.setOnClickListener(this)
        btnLihatSemuaUlasan.setOnClickListener(this)

    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Pilih "+bidangStudi[position].namaMapel, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_lihat_semua_galeri -> {
                val lihatGaleri = Intent(this, GaleriActivity::class.java)
                startActivity(lihatGaleri)
            }

            R.id.btn_lihat_semua_keahlian -> {
                botSheetKeahlian.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.btn_lihat_semua_paket_profile_guru -> {
                val lihatPaket = Intent(this, PaketProfileGuruActivity::class.java)
                startActivity(lihatPaket)
            }

            R.id.btn_lihat_semua_ulasan -> {
                val lihatUlasan = Intent(this, UlasanProfileGuruActivity::class.java)
                startActivity(lihatUlasan)
            }

        }
    }
}