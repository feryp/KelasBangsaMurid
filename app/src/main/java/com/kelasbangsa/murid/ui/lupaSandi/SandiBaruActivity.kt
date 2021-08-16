package com.kelasbangsa.murid.ui.lupaSandi

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import java.util.*

class SandiBaruActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var btnSimpan : MaterialButton
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandi_baru)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_sandi_baru)
        btnSimpan = findViewById(R.id.btn_simpan_sandi_baru)

        dialog = Dialog(this)


        //Set OnClick Listener
        btnSimpan.setOnClickListener(this)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

    }

    private fun showPopUp() {
        dialog.setContentView(R.layout.popup_sandi_berhasil)
        Objects.requireNonNull(dialog.window)!!
            .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_simpan_sandi_baru -> {
                showPopUp()
            }
        }
    }
}