package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class SignInActivity : AppCompatActivity() {

    var btnSignIn : MaterialButton? = null
    var btnToSignUp : MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //INIT VIEW
        btnSignIn = findViewById(R.id.btn_sign_in)
        btnToSignUp = findViewById(R.id.btn_to_sign_up)

        //Set OnClick Listener
        btnSignIn?.setOnClickListener{
            val signIn = Intent(this, MainActivity::class.java)
            startActivity(signIn)
        }

        btnToSignUp?.setOnClickListener{
            val toSignUp = Intent(this,SignUpActivity::class.java)
            startActivity(toSignUp)
        }
    }
}