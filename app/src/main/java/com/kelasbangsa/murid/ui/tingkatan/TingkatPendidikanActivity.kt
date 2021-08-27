package com.kelasbangsa.murid.ui.tingkatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.filter.BotsheetFilterProvinsiFragment
import com.kelasbangsa.murid.ui.guru.ProfileGuruActivity
import com.kelasbangsa.murid.ui.jadwal.BotsheetJadwalJamFragment

class TingkatPendidikanActivity : AppCompatActivity() {

    private lateinit var btnAturJam : MaterialButton
    val botsheetJam = BotsheetJadwalJamFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tingkat_pendidikan)

        btnAturJam = findViewById(R.id.btn_atur_jadwal_jam)

        btnAturJam.setOnClickListener {
            botsheetJam.show(supportFragmentManager, "BottomSheetDialog")
        }

    }
}