package com.kelasbangsa.murid.ui.akun

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView
import com.kelasbangsa.murid.ui.personalInfo.PersonalInfoActivity
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.notifikasi.NotifikasiActivity
import com.kelasbangsa.murid.ui.paketBelajar.PaketBelajarActivity
import com.kelasbangsa.murid.ui.tarikSaldo.TarikSaldoActivity
import com.kelasbangsa.murid.ui.transaksi.TransaksiActivity


class AkunFragment : Fragment(), View.OnClickListener  {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var menuSaldoAnda : MaterialCardView
    private lateinit var menuPersonalInfo : MaterialCardView
    private lateinit var menuTransaksi : MaterialCardView
    private lateinit var menuKeluhan : MaterialCardView
    private lateinit var menuPengaturan : MaterialCardView
    private lateinit var menuKeluar : MaterialCardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        //INIT VIEW
        toolbar = view.findViewById(R.id.toolbar_akun)
        menuSaldoAnda = view.findViewById(R.id.card_saldo_anda)
        menuPersonalInfo = view.findViewById(R.id.menu_personal_info_profile)
        menuTransaksi = view.findViewById(R.id.menu_transaksi_profile)
        menuKeluhan = view.findViewById(R.id.menu_keluhan_profile)
        menuPengaturan = view.findViewById(R.id.menu_pengaturan_profile)
        menuKeluar = view.findViewById(R.id.menu_keluar_profile)

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_notifikasi -> {
                    val notifikasi = Intent(activity, NotifikasiActivity::class.java)
                    startActivity(notifikasi)
                    true
                }
                else -> false
            }
        }

        //Set On Click Listener
        menuSaldoAnda.setOnClickListener(this)
        menuPersonalInfo.setOnClickListener(this)
        menuTransaksi.setOnClickListener(this)


        return view
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.card_saldo_anda -> {
                val tarikSaldo = Intent(context, TarikSaldoActivity::class.java)
                startActivity(tarikSaldo)
            }

            R.id.menu_personal_info_profile -> {
                val personalInfo = Intent(context, PersonalInfoActivity::class.java)
                startActivity(personalInfo)
            }

            R.id.menu_transaksi_profile -> {
                val transaksi = Intent(context, TransaksiActivity::class.java)
                startActivity(transaksi)
            }
        }
    }

}