package com.kelasbangsa.murid.ui.loginverification

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rentagown.v2.data.remote.RemoteRepositoryLocator
import com.goodiebag.pinview.Pinview
import com.google.android.material.button.MaterialButton
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.base.BaseActivity
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqVerification
import com.kelasbangsa.murid.data.network.Api
import com.kelasbangsa.murid.data.repository.RepositoryLocator
import com.kelasbangsa.murid.ui.main.MainActivity
import com.kelasbangsa.murid.ui.signin.SignInContract
import com.kelasbangsa.murid.ui.signin.SignInPresenter
import com.kelasbangsa.murid.ui.signup.SignUpActivity

class SignInVerificationActivity : BaseActivity<SignInVerificationContract.Presenter>(), SignInVerificationContract.View, View.OnClickListener {

    override val layoutId: Int = R.layout.activity_sign_in_verification

    override lateinit var presenter: SignInVerificationContract.Presenter

    private lateinit var pinView: Pinview
    private lateinit var btnVerify : MaterialButton
    private lateinit var btnSendAgain : MaterialButton

    override fun init() {
        super.init()

        presenter = SignInVerificationPresenter(
            RepositoryLocator.getInstance(
                RemoteRepositoryLocator
                    .getInstance(Api.apiService(this)))
                .authRepository)
    }

    override fun setupWidgets() {
        super.setupWidgets()

        pinView = findViewById(R.id.pin_view_sign_up)
        btnSendAgain = findViewById(R.id.btn_kirim_ulang_kode_otp)
        btnVerify = findViewById(R.id.btn_verifikasi_otp)

        pinView.setPinViewEventListener { pinview, fromUser ->
            Toast.makeText(this, pinview.value, Toast.LENGTH_SHORT).show()
        }

        //pin customize
        pinView.setTextSize(18)
        pinView.setTextSize(Color.BLACK)
        pinView.showCursor(true)

        btnSendAgain.setOnClickListener(this)
        btnVerify.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_verifikasi_otp -> {
                if(pinView.value != null) presenter.onBtnVerificationClicked(pinView.value)
                else showErrorMessage("Mohon isi OTP terlebih dahulu")
            }

            R.id.btn_kirim_ulang_kode_otp -> {

            }
        }
    }

    override fun navigateToHome() {
        val home = Intent(this, MainActivity::class.java)
        startActivity(home)
    }

    override fun getReqSignIn(): ReqSignIn? = intent.getParcelableExtra("reqSignIn")
}