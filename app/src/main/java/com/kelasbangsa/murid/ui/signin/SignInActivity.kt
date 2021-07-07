package com.kelasbangsa.murid.ui.signin

import android.content.Intent
import android.view.View
import com.example.rentagown.v2.data.remote.RemoteRepositoryLocator
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.base.BaseActivity
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.network.Api
import com.kelasbangsa.murid.data.repository.RepositoryLocator
import com.kelasbangsa.murid.ui.signup.SignUpActivity
import com.kelasbangsa.murid.ui.loginverification.SignInVerificationActivity
import com.kelasbangsa.murid.ui.forgotpassword.ForgotPasswordActivity

class SignInActivity : BaseActivity<SignInContract.Presenter>(), SignInContract.View, View.OnClickListener {

    override val layoutId: Int = R.layout.activity_sign_in

    override lateinit var presenter: SignInContract.Presenter

    private lateinit var etEmail : TextInputEditText
    private lateinit var etPassword : TextInputEditText
    private lateinit var btnSignIn : MaterialButton
    private lateinit var btnToSignUp : MaterialButton
    private lateinit var btnForgotPassword : MaterialButton


    override fun init() {
        super.init()

        presenter = SignInPresenter(
            RepositoryLocator.getInstance(
                RemoteRepositoryLocator
            .getInstance(Api.apiService(this)))
            .authRepository)
    }

    override fun setupWidgets() {
        super.setupWidgets()

        //INIT VIEW
        etEmail = findViewById(R.id.et_email_sign_in)
        etPassword = findViewById(R.id.et_kata_sandi_sign_in)
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
                if(etEmail.text.isNullOrEmpty()) showErrorMessage("Mohon isi email terlebih dahulu")
                else if(etPassword.text.isNullOrEmpty()) showErrorMessage("Mohon isi password terlebih dahulu")
                else presenter.onBtnSignInClicked(ReqSignIn(etPassword.text.toString(), etEmail.text.toString()))
            }

            R.id.btn_to_sign_up -> {
                presenter.onBtnSignUpClicked()
            }

            R.id.btn_forgot_password -> {
                presenter.onBtnForgotPasswordClicked()
            }
        }
    }

    override fun navigateToVerificationOTP(reqSignIn: ReqSignIn) {
        val verify = Intent(this, SignInVerificationActivity::class.java)
        verify.putExtra("reqSignIn", reqSignIn)
        startActivity(verify)
        finish()
    }

    override fun navigateToSignUp() {
        val toSignUp = Intent(this, SignUpActivity::class.java)
        startActivity(toSignUp)
    }

    override fun navigateToForgotPassword() {
        val forgotPassword = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(forgotPassword)
    }


}