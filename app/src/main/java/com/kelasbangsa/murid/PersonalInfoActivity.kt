package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PersonalInfoActivity : AppCompatActivity() {

    var btnBack : ImageButton? = null
    var btnEdit : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        btnEdit = findViewById(R.id.btn_edit)

        //Set OnClick Listener
        btnBack?.setOnClickListener {
            finish()
        }

        btnEdit?.setOnClickListener {
            val editProfile = Intent(this, EditProfileActivity::class.java)
            startActivity(editProfile)
        }
    }
}