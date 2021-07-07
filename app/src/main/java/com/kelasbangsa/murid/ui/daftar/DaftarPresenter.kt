package com.kelasbangsa.murid.ui.daftar

import android.text.TextUtils
import android.util.Patterns
import com.kelasbangsa.murid.base.BasePresenter
import com.kelasbangsa.murid.data.model.ReqDaftar
import com.kelasbangsa.murid.data.source.AuthDataSource

class DaftarPresenter(private val repository: AuthDataSource) : BasePresenter<DaftarContract.View>(), DaftarContract.Presenter {
    override fun onBtnSignUpClicked(reqDaftar: ReqDaftar) {
        if (isValidEmail(reqDaftar.email.toString())) {
            view?.showLoading(true)
            safeCallSingle(repository.signUp(reqDaftar), object : ListenerSingle {
                override fun onSuccess(status: String?) {
                    view?.navigateToSignIn()
                    view?.showMessage("Daftar akun berhasil!")
                }
            }, RequestConfiguration(updateLoadingContentIndicator = false))
        }else view?.showErrorMessage("Format email tidak valid")
    }

    override fun onBtnSignIn() {
        view?.navigateToSignIn()
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}