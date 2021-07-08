package com.kelasbangsa.murid.ui.personalInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.notifikasi.NotifikasiActivity
import com.kelasbangsa.murid.ui.ubahAkun.UbahAkunActivity

class PersonalInfoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack : ImageButton
    private lateinit var btnEdit : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnEdit = findViewById(R.id.btn_edit)

        //Set OnClick Listener
        btnBack.setOnClickListener(this)
        btnEdit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back ->{
                finish()
            }

            R.id.btn_edit ->{
                val editProfile = Intent(this, UbahAkunActivity::class.java)
                startActivity(editProfile)
            }
        }
    }
}