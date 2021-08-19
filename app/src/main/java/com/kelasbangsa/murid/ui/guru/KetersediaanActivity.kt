package com.kelasbangsa.murid.ui.guru

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.adapter.KetersediaanAdapter
import com.kelasbangsa.murid.adapter.ListGuruAdapter
import com.kelasbangsa.murid.data.model.Ketersediaan
import com.kelasbangsa.murid.ui.filter.FilterGuruActivity

class KetersediaanActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var rvKetersediaan : RecyclerView
    private lateinit var ketersediaan : MutableList<Ketersediaan>
    private lateinit var adapterKetersediaan : KetersediaanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ketersediaan)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_ketersediaan)
        rvKetersediaan = findViewById(R.id.rv_ketersediaan)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener{menuItem ->
            when(menuItem.itemId){
                R.id.action_search -> {
                    val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
                    val searchView : SearchView  = menuItem.actionView as SearchView

                    searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
                    true
                }
                else -> false
            }
        }

        //List ketersediaan
        ketersediaan = ArrayList()
        for (i : Int in 1..8)
            ketersediaan.add(
                Ketersediaan(
                    "Senin | Rabu | Kamis",
                    "08:00 - 09:00 AM"
                )
            )

        //Set adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterKetersediaan = KetersediaanAdapter(ketersediaan)
        rvKetersediaan.adapter = adapterKetersediaan
        rvKetersediaan.layoutManager = layoutManager
        rvKetersediaan.setHasFixedSize(true)
    }
}