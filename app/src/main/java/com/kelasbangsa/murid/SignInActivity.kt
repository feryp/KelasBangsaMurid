package com.kelasbangsa.murid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSignIn : MaterialButton
    private lateinit var btnToSignUp : MaterialButton
    private lateinit var btnForgotPassword : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //INIT VIEW
        btnSignIn = findViewById(R.id.btn_sign_in)
        btnToSignUp = findViewById(R.id.btn_to_sign_up)
        btnForgotPassword = findViewById(R.id.btn_forgot_password)

        //Set OnClick Listener
        btnSignIn.setOnClickListener(this)
        btnToSignUp.setOnClickListener(this)
        btnForgotPassword.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_sign_in -> {
                val signIn = Intent(this, MainActivity::class.java)
                startActivity(signIn)
            }

            R.id.btn_to_sign_up -> {
                val toSignUp = Intent(this,SignUpActivity::class.java)
                startActivity(toSignUp)
            }

            R.id.btn_forgot_password -> {
                val forgotPassword = Intent(this, LupaSandiActivity::class.java)
                startActivity(forgotPassword)
            }
        }
    }
}