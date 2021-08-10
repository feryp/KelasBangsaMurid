package com.kelasbangsa.murid.ui.paketBelajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.filter.BotsheetFilterBSFragment
import com.kelasbangsa.murid.ui.filter.BotsheetFilterKategoriFragment

class FilterPaketBelajarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var etKategori : ConstraintLayout
    private lateinit var etBidangStudi : ConstraintLayout
    val botsheetKategori = BotsheetFilterKategoriFragment()
    val botsheetBidangStudi = BotsheetFilterBSFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_paket_belajar)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_filter)
        etKategori = findViewById(R.id.container_pilih_kategori)
        etBidangStudi = findViewById(R.id.container_pilih_bs)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set OnClickListeenr
        etKategori.setOnClickListener(this)
        etBidangStudi.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.container_pilih_kategori -> {
                botsheetKategori.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_bs -> {
                botsheetBidangStudi.show(supportFragmentManager, "BottomSheetDialog")
            }

        }
    }
}