package com.kelasbangsa.murid.ui.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.KategoriBotSheetAdapter
import com.kelasbangsa.murid.adapter.ProvinsiBotsheetAdapter
import com.kelasbangsa.murid.data.model.Guru
import com.kelasbangsa.murid.data.model.Kategori

class BotsheetFilterKategoriFragment : BottomSheetDialogFragment(),OnItemClickListener {

    private lateinit var rvKategori : RecyclerView
    private lateinit var btnClose : ImageButton
    private lateinit var kategori : MutableList<Kategori>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botsheet_filter_kategori, container, false)

        //INIT VIEW
        rvKategori = view.findViewById(R.id.rv_kategori_botsheet)
        btnClose = view.findViewById(R.id.btn_close)

        //List kategori
        kategori = ArrayList()
        kategori.add(Kategori(1,0,"Akademik"))
        kategori.add(Kategori(2,0,"Bahasa"))
        kategori.add(Kategori(3,0,"Agama"))
        kategori.add(Kategori(4,0,"Keterampilan"))
        kategori.add(Kategori(5,0,"Teknologi"))
        kategori.add(Kategori(6,0,"Olahraga"))
        kategori.add(Kategori(7,0,"Musik"))

        //set adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = KategoriBotSheetAdapter(kategori, this)
        rvKategori.layoutManager = layoutManager
        rvKategori.adapter = adapter
        rvKategori.setHasFixedSize(true)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClose.setOnClickListener {
            dismiss()
        }

    }


    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Pilih "+kategori[position].namaKategori, Toast.LENGTH_SHORT).show()
    }

}