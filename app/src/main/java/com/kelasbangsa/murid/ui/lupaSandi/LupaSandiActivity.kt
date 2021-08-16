package com.kelasbangsa.murid.ui.lupaSandi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R

class LupaSandiActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnKirim : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_lupa_sandi)
        btnKirim = findViewById(R.id.btn_kirim_email)

        //Set OnClick Listener
        btnKirim.setOnClickListener(this)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_kirim_email -> {
                val kirimEmail = Intent(this, LupaSandiVerifikasiActivity::class.java)
                startActivity(kirimEmail)
            }
        }
    }
}