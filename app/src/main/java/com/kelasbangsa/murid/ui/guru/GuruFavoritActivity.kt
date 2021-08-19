package com.kelasbangsa.murid.ui.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.ListGuruAdapter
import com.kelasbangsa.murid.adapter.ListGuruFavoritAdapter
import com.kelasbangsa.murid.data.model.Guru
import com.kelasbangsa.murid.data.model.GuruFavorit
import com.kelasbangsa.murid.ui.filter.FilterGuruActivity
import com.kelasbangsa.murid.ui.filter.FilterGuruFavoritActivity

class GuruFavoritActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvGuruFavorit : RecyclerView
    private lateinit var guruFavorit : MutableList<GuruFavorit>
    private lateinit var adapterGuru : ListGuruFavoritAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guru_favorit)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_guru_favorit)
        rvGuruFavorit = findViewById(R.id.rv_guru_favorit)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.menu_filter -> {
                    val filter = Intent(this, FilterGuruFavoritActivity::class.java)
                    startActivity(filter)
                    true
                }
                else -> false
            }
        }

        //List guru
        guruFavorit = ArrayList()
        for (i : Int in 1..50)
            guruFavorit.add(
                GuruFavorit(
                    R.drawable.foto_example,
                    "Wiwin S, S.pd",
                    "Matematika",
                    "SMA",
                    "Kelas 10",
                    "Kecamatan Kelapa Gading, Kota Jakarta Utara",
                    "4.6",
                    "Rp 45.000"
                )
            )

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterGuru = ListGuruFavoritAdapter(guruFavorit, this)
        rvGuruFavorit.adapter = adapterGuru
        rvGuruFavorit.layoutManager = layoutManager
        rvGuruFavorit.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Pilih "+guruFavorit[position].namaGuru, Toast.LENGTH_SHORT).show()
        val profileGuru = Intent(this, ProfileGuruActivity::class.java)
        intent.putExtra("nama", guruFavorit[position].namaGuru)
        startActivity(profileGuru)
    }
}