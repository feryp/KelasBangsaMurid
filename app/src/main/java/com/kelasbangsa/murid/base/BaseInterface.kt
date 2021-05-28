package com.kelasbangsa.murid.base

interface BaseInterface {

    fun start()
    fun attachView(mView: Any?)
    fun detachView()
    fun cleanUp()
    fun onBackPressed()


}