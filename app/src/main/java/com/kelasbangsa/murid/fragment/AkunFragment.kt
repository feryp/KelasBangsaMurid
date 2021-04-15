package com.kelasbangsa.murid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.kelasbangsa.murid.PersonalInfoActivity
import com.kelasbangsa.murid.R


class AkunFragment : Fragment()   {


    var menuPersonalInfo : CardView? = null
    var menuTransaksi : CardView? = null
    var menuPengaturan : CardView? = null
    var menuKeluar : CardView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        //INIT VIEW
        menuPersonalInfo = view.findViewById(R.id.menu_personal_info_profile)
        menuTransaksi = view.findViewById(R.id.menu_transaksi_profile)
        menuPengaturan = view.findViewById(R.id.menu_pengaturan_profile)
        menuKeluar = view.findViewById(R.id.menu_keluar_profile)


        //Set On Click Listener
        menuPersonalInfo?.setOnClickListener {
            val personalInfo = Intent(activity, PersonalInfoActivity::class.java)
            startActivity(personalInfo)
        }


        return view
    }

}