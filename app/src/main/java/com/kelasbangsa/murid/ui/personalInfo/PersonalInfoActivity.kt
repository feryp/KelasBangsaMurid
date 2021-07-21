package com.kelasbangsa.murid.ui.personalInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.notifikasi.NotifikasiActivity
import com.kelasbangsa.murid.ui.ubahAkun.UbahAkunActivity

class PersonalInfoActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_personal_info)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_edit -> {
                    val ubahAkun = Intent(this, UbahAkunActivity::class.java)
                    startActivity(ubahAkun)
                    true
                }
                else -> false
            }
        }

    }

}