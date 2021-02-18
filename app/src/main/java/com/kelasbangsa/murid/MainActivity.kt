package com.kelasbangsa.murid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelasbangsa.murid.fragment.ChatFragment
import com.kelasbangsa.murid.fragment.HomeFragment
import com.kelasbangsa.murid.fragment.ProfileFragment
import com.kelasbangsa.murid.fragment.ScheduleFragment

class MainActivity : AppCompatActivity() {

    var bottomNavigationView : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INIT VIEW
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        //load first fragment by default
        loadFragment(HomeFragment())

        bottomNavigationView?.setOnNavigationItemSelectedListener { menuItem ->
            when{
                menuItem.itemId == R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_schedule -> {
                    loadFragment(ScheduleFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_chat -> {
                    loadFragment(ChatFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
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