package com.kelasbangsa.murid.ui.tarikSaldo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.pin.PinCodeActivity
import com.kelasbangsa.murid.ui.sandiBaru.GantiKataSandiActivity

class BotSheetPenarikanFragment : BottomSheetDialogFragment() {

    private lateinit var btnClose : ImageButton
    private lateinit var btnKirimSaldo : MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bot_sheet_penarikan, container, false)

        //INIT VIEW
        btnClose = view.findViewById(R.id.btn_close)
        btnKirimSaldo = view.findViewById(R.id.btn_kirim_penarikan)

        btnKirimSaldo.setOnClickListener {
            val kirimSaldo = Intent(context, PinCodeActivity::class.java)
            startActivity(kirimSaldo)
        }

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