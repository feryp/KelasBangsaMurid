package com.kelasbangsa.murid.ui.ulasan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R

class BeriUlasanActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beri_ulasan)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_beru_ulasan)

        toolbar.setNavigationOnClickListener {
            finish()
        }

    }
}