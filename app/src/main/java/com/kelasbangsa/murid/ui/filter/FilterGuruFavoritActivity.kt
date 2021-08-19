package com.kelasbangsa.murid.ui.filter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R

class FilterGuruFavoritActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var etProvinsi : ConstraintLayout
    private lateinit var etKota : ConstraintLayout
    private lateinit var etKategori : ConstraintLayout
    private lateinit var etBidangStudi : ConstraintLayout
    private lateinit var etTingPendidikan : ConstraintLayout
    val botsheetProvinsi = BotsheetFilterProvinsiFragment()
    val botSheetKota = BotsheetFilterKotaFragment()
    val botsheetKategori = BotsheetFilterKategoriFragment()
    val botsheetBidangStudi = BotsheetFilterBSFragment()
    val botsheetTingPendidikan = BotsheetFilterTingPendidikanFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_guru_favorit)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_filter)
        etProvinsi = findViewById(R.id.container_pilih_provinsi_favorit)
        etKota = findViewById(R.id.container_pilih_kota_favorit)
        etKategori = findViewById(R.id.container_pilih_kategori_favorit)
        etBidangStudi = findViewById(R.id.container_pilih_bidang_studi_favorit)
        etTingPendidikan = findViewById(R.id.container_pilih_ting_pendidikan_favorit)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        //Set OnClickListeenr
        etProvinsi.setOnClickListener(this)
        etKota.setOnClickListener(this)
        etKategori.setOnClickListener(this)
        etBidangStudi.setOnClickListener(this)
        etTingPendidikan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.container_pilih_provinsi_favorit -> {
                botsheetProvinsi.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_kota_favorit -> {
                botSheetKota.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_kategori_favorit -> {
                botsheetKategori.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_bidang_studi_favorit -> {
                botsheetBidangStudi.show(supportFragmentManager, "BottomSheetDialog")
            }

            R.id.container_pilih_ting_pendidikan_favorit -> {
                botsheetTingPendidikan.show(supportFragmentManager, "BottomSheetDialog")
            }

        }
    }
}