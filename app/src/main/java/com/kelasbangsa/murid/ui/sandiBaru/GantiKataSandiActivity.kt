package com.kelasbangsa.murid.ui.sandiBaru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R

class GantiKataSandiActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnSimpanSandi : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganti_kata_sandi)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_ganti_kata_sandi)
        btnSimpanSandi = findViewById(R.id.btn_simpan_ganti_kata_sandi)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}