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
import com.kelasbangsa.murid.adapter.KotaBotSheetAdapter
import com.kelasbangsa.murid.adapter.ProvinsiBotsheetAdapter
import com.kelasbangsa.murid.data.model.Kota
import com.kelasbangsa.murid.data.model.Provinsi

class BotsheetFilterKotaFragment : BottomSheetDialogFragment(), OnItemClickListener {

    private lateinit var rvKota : RecyclerView
    private lateinit var btnClose : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botsheet_filter_kota, container, false)

        //INIT VIEW
        rvKota = view.findViewById(R.id.rv_kota_botsheet)
        btnClose = view.findViewById(R.id.btn_close)

        //List kota
        val list : MutableList<Kota> = ArrayList()
        for (i : Int in 1..50)
            list.add(Kota("DKI Jakarta"))


        //set adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = KotaBotSheetAdapter(list, this)
        rvKota.layoutManager = layoutManager
        rvKota.adapter = adapter
        rvKota.setHasFixedSize(true)

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
        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
    }

}