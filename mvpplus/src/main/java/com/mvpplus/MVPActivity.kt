package com.mvpplus

/**
 * Created by lijun on 2019-08-21.
 */
class MVPActivity : BasePresenterActivity<HelloWordView>() {

    override fun getDelegateClass(): Class<HelloWordView> {
        return HelloWordView::class.java
    }

    override fun onBindData() {
        mDelegate?.setRemoteData("I am a first title!")
        mDelegate?.setReloadCallback(object : IReloadCallback {
            override fun onReload() {
                mDelegate?.setRemoteData("I am a second title!")
            }
        })
    }

    override fun onDestroyView() {
        mDelegate?.setReloadCallback(null)
    }
}