package com.kelasbangsa.murid.ui.jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelasbangsa.murid.R

class BotsheetJadwalJamFragment : BottomSheetDialogFragment() {

    private lateinit var btnClose : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botsheet_jadwal_jam, container, false)

        //INIT VIEW
        btnClose = view.findViewById(R.id.btn_close)


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