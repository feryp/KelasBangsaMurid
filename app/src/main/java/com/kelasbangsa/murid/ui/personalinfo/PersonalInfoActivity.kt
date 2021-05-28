package com.kelasbangsa.murid.ui.personalinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.changeaccount.ChangeAccountActivity

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
            val editProfile = Intent(this, ChangeAccountActivity::class.java)
            startActivity(editProfile)
        }
    }
}