package com.mvpplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by lijun on 2019-08-21.
 */
abstract class BasePresenterActivity<T : IDelegate> : AppCompatActivity() {

    protected var mDelegate: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDelegate = getDelegateClass().newInstance()
        mDelegate?.onCreateView(layoutInflater, null, savedInstanceState)
        setContentView(mDelegate?.getRootView())
        onBindData()
    }

    override fun onDestroy() {
        mDelegate?.onDestroyView()
        onDestroyView()
        mDelegate = null
        super.onDestroy()
    }

    abstract fun getDelegateClass(): Class<T>
    abstract fun onBindData()
    abstract fun onDestroyView()
}