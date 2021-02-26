package com.kelasbangsa.murid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.SliderGuruFavoritAdapter
import com.kelasbangsa.murid.adapter.SliderMapelFavoritAdapter
import com.kelasbangsa.murid.adapter.SliderPakerBelajarAdapter
import com.kelasbangsa.murid.model.GuruFavorit
import com.kelasbangsa.murid.model.MataPelajaran
import com.kelasbangsa.murid.model.PaketBelajar


class HomeFragment : Fragment() {

    var rvPaketBelajar : RecyclerView? = null
    var rvGuruFavorit : RecyclerView? = null
    var rvMapelFavorit : RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //INIT VIEW
        rvPaketBelajar = view.findViewById(R.id.rv_slider_paket_belajar)
        rvGuruFavorit = view.findViewById(R.id.rv_slider_guru_favorit)
        rvMapelFavorit = view.findViewById(R.id.rv_slider_mata_pelajaran_favorit)


        //List Paket Belajar
        val paket : MutableList<PaketBelajar> = ArrayList()
        for (i : Int in 1..10)
            paket.add(
                    PaketBelajar(
                            "Paket Matematika Dua",
                            "12 Des 2021",
                            "08:00 AM",
                            "09:00 AM",
                            "Tingkat SMA Kelas 10",
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
        rvPaketBelajar?.layoutManager = layoutManagerPaket
        rvPaketBelajar?.setHasFixedSize(true)
        rvPaketBelajar?.adapter = adapterPaket

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
        rvGuruFavorit?.layoutManager = layoutManagerGuru
        rvGuruFavorit?.setHasFixedSize(true)
        rvGuruFavorit?.adapter = adapterGuru

        //List Mata Pelajaran Favorit
        val mapel : MutableList<MataPelajaran> = ArrayList()
        for (i : Int in 1..20)
            mapel.add(
                MataPelajaran(
                    R.drawable.im_ak_ekonomi,
                    "Ekonomi"
                )
            )

        //set adapter mapel favorit
        val layoutManagerMapel = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        val adapterMapel = SliderMapelFavoritAdapter(mapel)
        rvMapelFavorit?.layoutManager = layoutManagerMapel
        rvMapelFavorit?.setHasFixedSize(true)
        rvMapelFavorit?.adapter = adapterMapel


        return view
    }
}