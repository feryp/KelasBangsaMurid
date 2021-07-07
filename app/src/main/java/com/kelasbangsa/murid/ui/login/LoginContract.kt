package com.kelasbangsa.murid.ui.login

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqLogin

class LoginContract {

    interface View : BaseView<Presenter> {
        fun navigateToVerificationOTP(reqLogin: ReqLogin)
        fun navigateToSignUp()
        fun navigateToForgotPassword()
    }

    interface Presenter : BaseInterface {
        fun onBtnSignInClicked(reqLogin: ReqLogin)
        fun onBtnSignUpClicked()
        fun onBtnForgotPasswordClicked()
    }
}