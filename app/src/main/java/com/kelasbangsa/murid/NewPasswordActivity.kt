package com.kelasbangsa.murid

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.util.*

class NewPasswordActivity : AppCompatActivity() {

    var btnBack : ImageButton? = null
    var btnSimpan : MaterialButton? = null
    var dialog : Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnSimpan = findViewById(R.id.btn_simpan_sandi_baru)

        dialog = Dialog(this)


        //Set OnClick Listener
        btnBack?.setOnClickListener {
            finish()
        }

        btnSimpan?.setOnClickListener {
            showPopUp()
        }


    }

    private fun showPopUp() {
        dialog?.setContentView(R.layout.popup_success_password)
        Objects.requireNonNull(dialog!!.window)!!
            .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()
    }
}