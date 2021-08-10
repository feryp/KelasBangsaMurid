package com.kelasbangsa.murid.ui.transaksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.TransaksiPageAdapter
import com.kelasbangsa.murid.ui.filter.FilterGuruActivity
import com.kelasbangsa.murid.ui.riwayat.RiwayatKelasActivity

class TransaksiActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var viewPager : ViewPager
    private lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_transaksi)
        viewPager = findViewById(R.id.vp_transaksi)
        tabLayout = findViewById(R.id.tab_transaksi)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_riwayat -> {
                    val riwayatKelas = Intent(this, RiwayatKelasActivity::class.java)
                    startActivity(riwayatKelas)
                    true
                }
                else -> false
            }
        }

        //Set adapter
        val fragmentAdapter = TransaksiPageAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        //Set tab layout with view pager
        tabLayout.setupWithViewPager(viewPager)

    }
}