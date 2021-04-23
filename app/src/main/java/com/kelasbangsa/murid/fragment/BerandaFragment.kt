package com.kelasbangsa.murid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.NotifikasiActivity
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.ItemClickListener
import com.kelasbangsa.murid.adapter.KategoriAdapter
import com.kelasbangsa.murid.adapter.SliderGuruFavoritAdapter
import com.kelasbangsa.murid.adapter.SliderBidangStudiFavoritAdapter
import com.kelasbangsa.murid.adapter.SliderPakerBelajarAdapter
import com.kelasbangsa.murid.model.GuruFavorit
import com.kelasbangsa.murid.model.Kategori
import com.kelasbangsa.murid.model.BidangStudi
import com.kelasbangsa.murid.model.PaketBelajar


class BerandaFragment : Fragment(), ItemClickListener, View.OnClickListener {

    private lateinit var btnNotifikasi : ImageButton
    private lateinit var rvKategori : RecyclerView
    private lateinit var rvPaketBelajar : RecyclerView
    private lateinit var rvGuruFavorit : RecyclerView
    private lateinit var rvMapelFavorit : RecyclerView
    private lateinit var adapterKategori : KategoriAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        //INIT VIEW
        btnNotifikasi = view.findViewById(R.id.btn_notification)
        rvKategori = view.findViewById(R.id.rv_kategori)
        rvPaketBelajar = view.findViewById(R.id.rv_slider_paket_belajar)
        rvGuruFavorit = view.findViewById(R.id.rv_slider_guru_favorit)
        rvMapelFavorit = view.findViewById(R.id.rv_slider_bidang_studi_favorit)

        //List Kategori
        val kategori : MutableList<Kategori> = ArrayList()
        kategori.add(Kategori(1,R.drawable.ic_kategori_akademik,"Akademik"))
        kategori.add(Kategori(2, R.drawable.ic_kategori_bahasa,"Bahasa"))
        kategori.add(Kategori(3, R.drawable.ic_kategori_agama,"Agama"))
        kategori.add(Kategori(4, R.drawable.ic_kategori_keterampilan,"Keterampilan"))
        kategori.add(Kategori(5, R.drawable.ic_kategori_teknologi,"Teknologi"))
        kategori.add(Kategori(6, R.drawable.ic_kategori_olahraga,"Olahraga"))
        kategori.add(Kategori(7, R.drawable.ic_kategori_musik,"Musik"))
        kategori.add(Kategori(8, R.drawable.ic_kategori_semua,"Semua"))

        //set adapter kategori
        val layoutManagerKategori = GridLayoutManager(context,4)
        adapterKategori = KategoriAdapter(kategori, this)
        rvKategori.layoutManager = layoutManagerKategori
        rvKategori.adapter = adapterKategori
        rvKategori.setHasFixedSize(true)
        adapterKategori.selectedCategory(0)


        //List Paket Belajar
        val paket : MutableList<PaketBelajar> = ArrayList()
        for (i : Int in 1..10)
            paket.add(
                    PaketBelajar(
                            "Paket Matematika Dua",
                            "12 Des 2021",
                            "08:00 AM",
                            "09:00 AM",
                            "SMA",
                            "Kelas 10",
                            2,
                            R.drawable.foto_example,
                            "Sarah Amalia Pratami",
                            "SMAN 70 Jakarta, Jl. Bulungan Blok C/1, Kramat Pela, Kebayoran Baru, Jakarta Selatan, DKI Jakarta, Indonesia",
                            "Rp 40.000"
                    )
            )

        //set adapter paket belajar
        val layoutManagerPaket = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapterPaket = SliderPakerBelajarAdapter(paket)
        rvPaketBelajar.layoutManager = layoutManagerPaket
        rvPaketBelajar.setHasFixedSize(true)
        rvPaketBelajar.adapter = adapterPaket

        //List Guru Favorit
        val guru : MutableList<GuruFavorit> = ArrayList()
        for (i : Int in 1..20)
            guru.add(
                GuruFavorit(
                    R.drawable.foto_example,
                    "Sarifudin, S.pd"
                )
            )

        //set adapter guru favorit
        val layoutManagerGuru = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapterGuru = SliderGuruFavoritAdapter(guru)
        rvGuruFavorit.layoutManager = layoutManagerGuru
        rvGuruFavorit.setHasFixedSize(true)
        rvGuruFavorit.adapter = adapterGuru

        //List Mata Pelajaran Favorit
        val bidangStudi : MutableList<BidangStudi> = ArrayList()
        for (i : Int in 1..20)
            bidangStudi.add(
                BidangStudi(
                    R.drawable.im_ak_ekonomi,
                    "Ekonomi"
                )
            )

        //set adapter bidang studi favorit
        val layoutManagerBS = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        val adapterBS = SliderBidangStudiFavoritAdapter(bidangStudi)
        rvMapelFavorit.layoutManager = layoutManagerBS
        rvMapelFavorit.setHasFixedSize(true)
        rvMapelFavorit.adapter = adapterBS

        //Set OnClick Listener
        btnNotifikasi.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_notification ->{
                val notifikasi = Intent(activity, NotifikasiActivity::class.java)
                startActivity(notifikasi)
            }
        }
    }

    override fun onItemClick(v: View, pos: Int) {
        when(v.id){
            R.id.container_kategori -> {
                val kat : Kategori = adapterKategori.getItem(pos)
            }
        }
    }
}