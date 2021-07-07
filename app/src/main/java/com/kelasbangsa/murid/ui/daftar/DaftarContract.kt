package com.kelasbangsa.murid.ui.daftar

import com.kelasbangsa.murid.base.BaseInterface
import com.kelasbangsa.murid.base.BaseView
import com.kelasbangsa.murid.data.model.ReqDaftar

class DaftarContract {

    interface View : BaseView<Presenter> {
        fun navigateToSignIn()
    }

    interface Presenter : BaseInterface {
        fun onBtnSignUpClicked(reqDaftar: ReqDaftar)
        fun onBtnSignIn()
    }
}