package com.kelasbangsa.murid.ui.beranda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.ui.notifikasi.NotifikasiActivity
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.KategoriAdapter
import com.kelasbangsa.murid.adapter.SliderGuruFavoritAdapter
import com.kelasbangsa.murid.adapter.SliderBidangStudiAdapter
import com.kelasbangsa.murid.adapter.SliderPakerBelajarAdapter
import com.kelasbangsa.murid.data.model.GuruFavorit
import com.kelasbangsa.murid.data.model.Kategori
import com.kelasbangsa.murid.data.model.BidangStudi
import com.kelasbangsa.murid.data.model.PaketBelajar
import com.kelasbangsa.murid.ui.kategori.*
import com.kelasbangsa.murid.ui.semuaKategori.SemuaKategoriActivity


class BerandaFragment : Fragment(), View.OnClickListener, OnItemClickListener{

    private lateinit var btnNotifikasi : ImageButton
    private lateinit var rvKategori : RecyclerView
    private lateinit var rvPaketBelajar : RecyclerView
    private lateinit var rvGuruFavorit : RecyclerView
    private lateinit var rvMapelFavorit : RecyclerView
    private lateinit var adapterKategori : KategoriAdapter

    var kategori : MutableList<Kategori> = ArrayList()
    var paket : MutableList<PaketBelajar> = ArrayList()
    var guru : MutableList<GuruFavorit> = ArrayList()

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
//        adapterKategori.selectedCategory(0)


        //Slider Paket Belajar
        for (i : Int in 1..10)
            paket.add(
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
                             R.drawable.foto_example,
                            "Wiwin S, S.pd",
                            "",
                            "Rp 40.000"

                    )
            )

        //set adapter slider paket belajar
        val layoutManagerPaket = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapterPaket = SliderPakerBelajarAdapter(paket)
        rvPaketBelajar.layoutManager = layoutManagerPaket
        rvPaketBelajar.setHasFixedSize(true)
        rvPaketBelajar.adapter = adapterPaket

        //Slider Guru Favorit
        for (i : Int in 1..20)
            guru.add(
                GuruFavorit(
                    R.drawable.foto_example,
                    "Sarifudin, S.pd"
                )
            )

        //set adapter slider guru favorit
        val layoutManagerGuru = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapterGuru = SliderGuruFavoritAdapter(guru)
        rvGuruFavorit.layoutManager = layoutManagerGuru
        rvGuruFavorit.setHasFixedSize(true)
        rvGuruFavorit.adapter = adapterGuru

        //Slider Mata Pelajaran Favorit
        val bidangStudi : MutableList<BidangStudi> = ArrayList()
        for (i : Int in 1..20)
            bidangStudi.add(
                BidangStudi(
                    R.drawable.im_ak_ekonomi,
                    "Ekonomi"
                )
            )

        //set adapter slider bidang studi favorit
        val layoutManagerBS = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        val adapterBS = SliderBidangStudiAdapter(bidangStudi, this)
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


    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Pilih "+kategori[position].namaKategori, Toast.LENGTH_SHORT).show()
        when(position){
            0-> {
                val akademik = Intent(context, KategoriAkademikActivity::class.java)
                startActivity(akademik)
            }
            1-> {
                val bahasa = Intent(context, KategoriBahasaActivity::class.java)
                startActivity(bahasa)
            }
            2-> {
                val agama = Intent(context, KategoriAgamaActivity::class.java)
                startActivity(agama)
            }
            3-> {
                val keterampilan = Intent(context, KategoriKeterampilanActivity::class.java)
                startActivity(keterampilan)
            }
            4-> {
                val teknologi = Intent(context, KategoriTeknologiActivity::class.java)
                startActivity(teknologi)
            }
            5-> {
                val olahraga = Intent(context, KategoriOlahragaActivity::class.java)
                startActivity(olahraga)
            }
            6-> {
                val musik = Intent(context, KategoriMusikActivity::class.java)
                startActivity(musik)
            }
            7-> {
                val semua = Intent(context, SemuaKategoriActivity::class.java)
                startActivity(semua)
            }

        }
    }
}