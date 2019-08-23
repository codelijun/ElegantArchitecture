package com.mvpplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by lijun on 2019-08-21.
 */
class HelloWordView : IDelegate {

    private var mContainerView: View? = null
    private var mContextView: TextView? = null

    private var mReloadCallback: IReloadCallback? = null

    override fun onCreateView(
        layoutInflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        mContainerView = layoutInflater.inflate(R.layout.activity_mpv_plus, container)
        mContextView = mContainerView?.findViewById(R.id.text_view)
        mContainerView?.setOnClickListener {
            mReloadCallback?.onReload()
        }
    }

    override fun getRootView(): View? {
        return mContainerView
    }

    fun setRemoteData(content: CharSequence) {
        mContextView?.text = content
    }

    fun setReloadCallback(reloadCallback: IReloadCallback?) {
        mReloadCallback = reloadCallback
    }

    override fun onDestroyView() {
        mContainerView?.setOnClickListener(null)
    }
}