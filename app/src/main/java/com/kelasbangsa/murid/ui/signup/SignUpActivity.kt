package com.kelasbangsa.murid.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rentagown.v2.data.remote.RemoteRepositoryLocator
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.base.BaseActivity
import com.kelasbangsa.murid.data.model.ReqSignUp
import com.kelasbangsa.murid.data.network.Api
import com.kelasbangsa.murid.data.repository.RepositoryLocator
import com.kelasbangsa.murid.ui.signin.SignInActivity
import com.kelasbangsa.murid.ui.signin.SignInContract
import com.kelasbangsa.murid.ui.signin.SignInPresenter

class SignUpActivity : BaseActivity<SignUpContract.Presenter>(), SignUpContract.View, View.OnClickListener {

    override val layoutId: Int = R.layout.activity_sign_up

    override lateinit var presenter: SignUpContract.Presenter

    private lateinit var etName : TextInputEditText
    private lateinit var etEmail : TextInputEditText
    private lateinit var etPhone : TextInputEditText
    private lateinit var etPassword : TextInputEditText
    private lateinit var checkBox : MaterialCheckBox
    private lateinit var btnSignUp : MaterialButton
    private lateinit var btnToSignIn : MaterialButton

    override fun init() {
        super.init()

        presenter = SignUpPresenter(
            RepositoryLocator.getInstance(
                RemoteRepositoryLocator
                    .getInstance(Api.apiService(this)))
                .authRepository)
    }

    override fun setupWidgets() {
        super.setupWidgets()

        //INIT VIEW
        etName = findViewById(R.id.et_nama_sign_up)
        etEmail = findViewById(R.id.et_email_sign_up)
        etPhone = findViewById(R.id.et_no_telepon_sign_up)
        etPassword = findViewById(R.id.et_kata_sandi_sign_up)
        checkBox = findViewById(R.id.checkbox_sk)
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnToSignIn = findViewById(R.id.btn_to_sign_in)

        //Set OnClick Listener
        btnSignUp.setOnClickListener(this)
        btnToSignIn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_sign_up -> {
                if(etName.text.isNullOrEmpty()) showErrorMessage("Mohon isi nama terlebih dahulu")
                else if(etEmail.text.isNullOrEmpty()) showErrorMessage("Mohon isi email terlebih dahulu")
                else if(etPhone.text.isNullOrEmpty()) showErrorMessage("Mohon isi nomor telepon terlebih dahulu")
                else if(etPassword.text.isNullOrEmpty()) showErrorMessage("Mohon isi password terlebih dahulu")
                else {
                    if (checkBox.isChecked) presenter.onBtnSignUpClicked(
                        ReqSignUp(
                            etName.text.toString(),
                            etEmail.text.toString(),
                            etPhone.text.toString(),
                            etPassword.text.toString()
                        )
                    )
                    else showErrorMessage("Mohon untuk menyetujui syarat dan ketentuan yang berlaku terlebih dahulu")
                }
            }

            R.id.btn_to_sign_in -> {
                presenter.onBtnSignIn()
            }
        }
    }

    override fun navigateToSignIn() {
        val  toSignIn = Intent(this, SignInActivity::class.java)
        startActivity(toSignIn)
    }
}