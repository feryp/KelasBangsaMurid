package com.kelasbangsa.murid.ui.loginVerifikasi

import com.kelasbangsa.murid.base.BasePresenter
import com.kelasbangsa.murid.data.model.ReqVerifikasi
import com.kelasbangsa.murid.data.source.AuthDataSource

class LoginVerifikasiPresenter(private val repository: AuthDataSource) : BasePresenter<LoginVerifikasiContract.View>(), LoginVerifikasiContract.Presenter {
    override fun onBtnVerificationClicked(otp: String) {
        val authLogin = view?.getReqSignIn()

        val mReqVerify = ReqVerifikasi(
            authLogin?.email,
            "12l3h1l2i31lbPWwqK21UiV7TesTKLSSHJDK",
            otp
        )

        if(otp == null || otp.length == 0) view?.showErrorMessage("Mohon isi otp terlebih dahulu")
        else {
            view?.showLoading(true)
            safeCallSingle(repository.verify(mReqVerify), object : ListenerSingle {
                override fun onSuccess(status: String?) {
                    view?.navigateToHome()
                    view?.showMessage("Welcome!")
                }
            }, RequestConfiguration(updateLoadingContentIndicator = false))
        }
    }

    override fun onBtnSendAgain() {
        val authLogin = view?.getReqSignIn()

        if(authLogin != null) {
            view?.showLoading(true)
            safeCallSingle(repository.signIn(authLogin), object : ListenerSingle {
                override fun onSuccess(status: String?) {
                    view?.showMessage("Kode OTP sudah dikirim ke email anda")
                }
            }, RequestConfiguration(updateLoadingContentIndicator = false))
        }else view?.showErrorMessage("Terjadi kesalahan")
    }

}