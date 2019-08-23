package com.mvpplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by lijun on 2019-08-21.
 */
interface IDelegate {
    fun onCreateView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )

    fun getRootView(): View?
    fun onDestroyView()
}