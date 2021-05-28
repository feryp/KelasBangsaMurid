package com.kelasbangsa.murid.ui.signin

import android.text.TextUtils
import android.util.Patterns
import com.kelasbangsa.murid.base.BasePresenter
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.source.AuthDataSource

class SignInPresenter(private val repository: AuthDataSource) : BasePresenter<SignInContract.View>(), SignInContract.Presenter {
    override fun onBtnSignInClicked(reqSignIn: ReqSignIn) {
        if (isValidEmail(reqSignIn.email.toString())) {
            view?.showLoading(true)
//            Ini manggil API
            safeCallSingle(repository.signIn(reqSignIn), object : ListenerSingle {
                override fun onSuccess(status: String?) {
                    view?.navigateToVerificationOTP(reqSignIn)
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