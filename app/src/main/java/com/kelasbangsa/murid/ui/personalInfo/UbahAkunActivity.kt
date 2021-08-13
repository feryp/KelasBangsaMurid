package com.kelasbangsa.murid.ui.personalInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.core.view.forEach
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.radiobutton.MaterialRadioButton
import com.kelasbangsa.murid.R

class UbahAkunActivity : AppCompatActivity() {

    private lateinit var rbPria : MaterialRadioButton
    private lateinit var rbWanita : MaterialRadioButton
    private lateinit var radioGroup : RadioGroup
    private lateinit var toolbar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_akun)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_ubah_akun)
        radioGroup = findViewById(R.id.radio_group)
        rbPria = findViewById(R.id.rb_pria)
        rbWanita = findViewById(R.id.rb_wanita)

        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            findViewById<MaterialRadioButton>(i)?.apply {
                updateRadioButtonStyle()
            }
        }
    }

    private fun updateRadioButtonStyle(){
        radioGroup.forEach {
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