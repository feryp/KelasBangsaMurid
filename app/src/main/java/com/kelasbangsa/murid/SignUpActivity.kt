package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class SignUpActivity : AppCompatActivity() {

    var btnSignUp : MaterialButton? = null
    var btnToSignIn : MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //INIT VIEW
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnToSignIn = findViewById(R.id.btn_to_sign_in)

        //Set OnClick Listener
        btnSignUp?.setOnClickListener{
            //belum
        }

        btnToSignIn?.setOnClickListener{
            val  toSignIn = Intent(this, SignInActivity::class.java)
            startActivity(toSignIn)
        }
    }
}