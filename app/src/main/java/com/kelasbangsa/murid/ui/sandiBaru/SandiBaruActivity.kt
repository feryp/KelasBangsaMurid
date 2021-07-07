package com.kelasbangsa.murid.ui.sandiBaru

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import java.util.*

class SandiBaruActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack : ImageButton
    private lateinit var btnSimpan : MaterialButton
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandi_baru)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnSimpan = findViewById(R.id.btn_simpan_sandi_baru)

        dialog = Dialog(this)


        //Set OnClick Listener
        btnBack.setOnClickListener(this)
        btnSimpan.setOnClickListener(this)


    }

    private fun showPopUp() {
        dialog.setContentView(R.layout.popup_sandi_berhasil)
        Objects.requireNonNull(dialog.window)!!
            .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_back -> {
                finish()
            }

            R.id.btn_simpan_sandi_baru -> {
                showPopUp()
            }
        }
    }
}