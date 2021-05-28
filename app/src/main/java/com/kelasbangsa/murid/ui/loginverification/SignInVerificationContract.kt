package com.kelasbangsa.murid.ui.loginverification

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqVerification

class SignInVerificationContract {

    interface View : BaseView<Presenter> {
        fun navigateToHome()
        fun getReqSignIn(): ReqSignIn?
    }

    interface Presenter : BaseInterface {
        fun onBtnVerificationClicked(otp: String)
        fun onBtnSendAgain()
    }
}