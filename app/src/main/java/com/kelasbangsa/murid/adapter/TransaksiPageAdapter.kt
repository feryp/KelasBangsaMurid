package com.kelasbangsa.murid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kelasbangsa.murid.ui.transaksi.TransaksiProsesFragment
import com.kelasbangsa.murid.ui.transaksi.TransaksiSelesaiFragment

class TransaksiPageAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TransaksiProsesFragment()
            } else -> {
                return TransaksiSelesaiFragment()
            }
            //this method is set our tabs positions
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position){
            0 -> "Proses"
            else -> {
                return "Selesai"
            }
            //and this method will set out tabs titles
        }
    }


}