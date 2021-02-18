package com.kelasbangsa.murid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.SliderPakerBelajarAdapter
import com.kelasbangsa.murid.model.PaketBelajar


class HomeFragment : Fragment() {

    var rvPaketBelajar : RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //INIT VIEW
        rvPaketBelajar = view.findViewById(R.id.rv_slider_paket_belajar)

        val data : MutableList<PaketBelajar> = ArrayList()
        for (i : Int in 1..6)
            data.add(
                PaketBelajar(
                    "Paket Matematika Satu",
                    "12 Desember 2021",
                    "08:00 AM",
                    "09:00 AM",
                    "Tingkat SMA Kelas 10",
                    2,
                    R.drawable.foto_example,
                    "John Doe",
                    "SMAN 70 Jakarta, Jl. Bulungan Blok C/1, Kramat Pela, Kebayoran Baru, Jakarta Selatan, DKI Jakarta, Indonesia",
                    "Rp 40.000"
                )
            )

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //set adapter
        val adapter = SliderPakerBelajarAdapter(data)
        rvPaketBelajar?.layoutManager = layoutManager
        rvPaketBelajar?.setHasFixedSize(true)
        rvPaketBelajar?.adapter = adapter

        return view
    }
}