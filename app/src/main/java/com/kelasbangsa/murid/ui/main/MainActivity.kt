package com.kelasbangsa.murid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.obrolan.ObrolanFragment
import com.kelasbangsa.murid.ui.beranda.BerandaFragment
import com.kelasbangsa.murid.ui.akun.AkunFragment
import com.kelasbangsa.murid.ui.jadwalKelas.JadwalFragment

class MainActivity : AppCompatActivity() {

    var bottomNavigationView : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INIT VIEW
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        //load first fragment by default
        loadFragment(BerandaFragment())

        bottomNavigationView?.setOnNavigationItemSelectedListener { menuItem ->
            when{
                menuItem.itemId == R.id.nav_home -> {
                    loadFragment(BerandaFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_schedule -> {
                    loadFragment(JadwalFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_chat -> {
                    loadFragment(ObrolanFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_profile -> {
                    loadFragment(AkunFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }
    }
}