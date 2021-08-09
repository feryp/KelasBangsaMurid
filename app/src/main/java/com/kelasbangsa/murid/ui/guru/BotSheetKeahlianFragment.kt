package com.kelasbangsa.murid.ui.guru

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.KeahlianAdapter
import com.kelasbangsa.murid.adapter.KeahlianBotSheetAdapter
import com.kelasbangsa.murid.adapter.KotaBotSheetAdapter
import com.kelasbangsa.murid.data.model.Keahlian


class BotSheetKeahlianFragment : BottomSheetDialogFragment() {

    private lateinit var rvKeahlian : RecyclerView
    private lateinit var btnClose : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bot_sheet_keahlian, container, false)

        //INIT VIEW
        rvKeahlian = view.findViewById(R.id.rv_keahlian_botsheet)
        btnClose = view.findViewById(R.id.btn_close)

        //List Keahlian
        val list : MutableList<Keahlian> = ArrayList()
        list.add(Keahlian("Aljabar Linier"))
        list.add(Keahlian("Geometri"))
        list.add(Keahlian("Peluang"))
        list.add(Keahlian("Aritmetika"))
        list.add(Keahlian("Trigonometri"))
        list.add(Keahlian("Adobe XD"))
        list.add(Keahlian("Adobe Photoshop"))

        //set adapter
        val layoutManager = GridLayoutManager(context, 3)
        val adapter = KeahlianBotSheetAdapter(list)
        rvKeahlian.layoutManager = layoutManager
        rvKeahlian.adapter = adapter
        rvKeahlian.setHasFixedSize(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClose.setOnClickListener {
            dismiss()
        }

    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme
}