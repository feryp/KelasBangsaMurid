package com.kelasbangsa.murid.ui.loginVerifikasi

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqLogin

class LoginVerifikasiContract {

    interface View : BaseView<Presenter> {
        fun navigateToHome()
        fun getReqSignIn(): ReqLogin?
    }

    interface Presenter : BaseInterface {
        fun onBtnVerificationClicked(otp: String)
        fun onBtnSendAgain()
    }
}