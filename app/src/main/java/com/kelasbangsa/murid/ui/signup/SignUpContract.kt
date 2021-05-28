package com.kelasbangsa.murid.ui.signup

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqSignIn
import com.kelasbangsa.murid.data.model.ReqSignUp

class SignUpContract {

    interface View : BaseView<Presenter> {
        fun navigateToSignIn()
    }

    interface Presenter : BaseInterface {
        fun onBtnSignUpClicked(reqSignUp: ReqSignUp)
        fun onBtnSignIn()
    }
}