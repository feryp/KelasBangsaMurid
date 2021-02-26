package com.kelasbangsa.murid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioGroup
import androidx.core.view.forEach
import com.google.android.material.radiobutton.MaterialRadioButton

class EditProfileActivity : AppCompatActivity() {

    var rbPria : MaterialRadioButton? = null
    var rbWanita : MaterialRadioButton? = null
    var radioGroup : RadioGroup? = null
    var btnBack : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        //INIT VIEW
        btnBack = findViewById(R.id.btn_back)
        radioGroup = findViewById(R.id.radio_group)
        rbPria = findViewById(R.id.rb_pria)
        rbWanita = findViewById(R.id.rb_wanita)

        //Set OnClick Listener
        btnBack?.setOnClickListener {
            finish()
        }

        radioGroup?.setOnCheckedChangeListener { radioGroup, i ->
            findViewById<MaterialRadioButton>(i)?.apply {
                updateRadioButtonStyle()
            }
        }
    }

    private fun updateRadioButtonStyle(){
        radioGroup?.forEach {
            (it as MaterialRadioButton).apply {
                if (isChecked){
                    setTextColor(Color.parseColor("#C8232C"))
                } else{
                    setTextColor(Color.parseColor("#BCBCBC"))
                }
            }
        }
    }


}