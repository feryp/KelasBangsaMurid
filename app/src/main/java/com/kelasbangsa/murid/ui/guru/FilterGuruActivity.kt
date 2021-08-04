package com.kelasbangsa.murid.ui.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelasbangsa.murid.R

class FilterGuruActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var etProvinsi : ConstraintLayout
    private lateinit var etKota : ConstraintLayout
    val botsheetProvinsi = BotsheetFilterProvinsiFragment()
    val botSheetKota = BotsheetFilterKotaFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_guru)
        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_filter)
        etProvinsi = findViewById(R.id.container_pilih_provinsi)
        etKota = findViewById(R.id.container_pilih_kota)

        toolbar.setNavigationOnClickListener {
            finish()
        }


        //Set OnClickListeenr
        etProvinsi.setOnClickListener(this)
        etKota.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.container_pilih_provinsi -> {
                botsheetProvinsi.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_kota -> {
                botSheetKota.show(supportFragmentManager, "BottomSheetDialog")
            }

        }
    }
}