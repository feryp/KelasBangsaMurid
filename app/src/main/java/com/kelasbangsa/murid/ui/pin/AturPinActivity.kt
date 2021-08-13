package com.kelasbangsa.murid.ui.pin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R

class AturPinActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atur_pin_activity)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pin)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}