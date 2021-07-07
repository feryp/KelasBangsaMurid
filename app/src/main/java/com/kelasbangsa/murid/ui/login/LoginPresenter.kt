package com.kelasbangsa.murid.ui.login

import android.text.TextUtils
import android.util.Patterns
import com.kelasbangsa.murid.base.BasePresenter
import com.kelasbangsa.murid.data.model.ReqLogin
import com.kelasbangsa.murid.data.source.AuthDataSource

class LoginPresenter(private val repository: AuthDataSource) : BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    override fun onBtnSignInClicked(reqLogin: ReqLogin) {
        if (isValidEmail(reqLogin.email.toString())) {
            view?.showLoading(true)
//            Ini manggil API
            safeCallSingle(repository.signIn(reqLogin), object : ListenerSingle {
                override fun onSuccess(status: String?) {
                    view?.navigateToVerificationOTP(reqLogin)
                }
            }, RequestConfiguration(updateLoadingContentIndicator = false))
        }else view?.showErrorMessage("Format email tidak valid")
    }

    override fun onBtnSignUpClicked() {
        view?.navigateToSignUp()
    }

    override fun onBtnForgotPasswordClicked() {
        view?.navigateToForgotPassword()
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}