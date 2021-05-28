package com.kelasbangsa.murid.ui.signin

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqSignIn

class SignInContract {

    interface View : BaseView<Presenter> {
        fun navigateToVerificationOTP(reqSignIn: ReqSignIn)
        fun navigateToSignUp()
        fun navigateToForgotPassword()
    }

    interface Presenter : BaseInterface {
        fun onBtnSignInClicked(reqSignIn: ReqSignIn)
        fun onBtnSignUpClicked()
        fun onBtnForgotPasswordClicked()
    }
}