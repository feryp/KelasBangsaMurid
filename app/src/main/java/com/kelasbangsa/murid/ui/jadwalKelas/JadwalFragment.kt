package com.kelasbangsa.murid.ui.jadwalKelas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R


class JadwalFragment : Fragment() {

    private lateinit var toolbar : MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_jadwal, container, false)

        //INIT VIEW
        toolbar = view.findViewById(R.id.toolbar_jadwal)


        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_calendar -> {
                    //handle calendar
                    true
                }
                else -> false
            }
        }
        return view
    }

}