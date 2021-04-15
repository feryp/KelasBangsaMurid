package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSignUp : MaterialButton
    private lateinit var btnToSignIn : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //INIT VIEW
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnToSignIn = findViewById(R.id.btn_to_sign_in)

        //Set OnClick Listener
        btnSignUp.setOnClickListener(this)
        btnToSignIn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_sign_up -> {
                val signUp = Intent(this,VerifikasiDaftarActivity::class.java)
                startActivity(signUp)
            }

            R.id.btn_to_sign_in -> {
                val  toSignIn = Intent(this, SignInActivity::class.java)
                startActivity(toSignIn)
            }
        }
    }
}