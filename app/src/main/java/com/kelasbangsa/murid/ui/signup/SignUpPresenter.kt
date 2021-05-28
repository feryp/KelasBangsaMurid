package com.kelasbangsa.murid.ui.signup

import android.text.TextUtils
import android.util.Patterns
import com.kelasbangsa.murid.base.BasePresenter
import com.kelasbangsa.murid.data.model.ReqSignUp
import com.kelasbangsa.murid.data.source.AuthDataSource

class SignUpPresenter(private val repository: AuthDataSource) : BasePresenter<SignUpContract.View>(), SignUpContract.Presenter {
    override fun onBtnSignUpClicked(reqSignUp: ReqSignUp) {
        if (isValidEmail(reqSignUp.email.toString())) {
            view?.showLoading(true)
            safeCallSingle(repository.signUp(reqSignUp), object : ListenerSingle {
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