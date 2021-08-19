package com.kelasbangsa.murid.ui.filter

import android.os.Bundle
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
import com.kelasbangsa.murid.adapter.BidangStudiBotSheetAdapter
import com.kelasbangsa.murid.adapter.TingPendidikanBotSheetAdapter
import com.kelasbangsa.murid.data.model.TingkatPendidikan


class BotsheetFilterTingPendidikanFragment : BottomSheetDialogFragment(), OnItemClickListener {

    private lateinit var rvTingPendidikan : RecyclerView
    private lateinit var btnClose : ImageButton
    private lateinit var tingPendidikan : MutableList<TingkatPendidikan>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botsheet_filter_ting_pendidikan, container, false)

        //INIT VIEW
        rvTingPendidikan = view.findViewById(R.id.rv_ting_pendidikan_botsheet)
        btnClose = view.findViewById(R.id.btn_close)

        //List tingkat pendidikan
        tingPendidikan = ArrayList()
        tingPendidikan.add(TingkatPendidikan("TK-PAUD"))
        tingPendidikan.add(TingkatPendidikan("Sekolah Dasar (SD)"))
        tingPendidikan.add(TingkatPendidikan("Sekolah Menengah Pertama (SMP)"))
        tingPendidikan.add(TingkatPendidikan("Sekolah Menengah Akhir (SMA)"))
        tingPendidikan.add(TingkatPendidikan("Universitas"))
        tingPendidikan.add(TingkatPendidikan("Umum"))

        //set adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = TingPendidikanBotSheetAdapter(tingPendidikan, this)
        rvTingPendidikan.layoutManager = layoutManager
        rvTingPendidikan.adapter = adapter
        rvTingPendidikan.setHasFixedSize(true)


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
        Toast.makeText(context, "Pilih "+tingPendidikan[position].tingkatPendidikan, Toast.LENGTH_SHORT).show()
    }

}