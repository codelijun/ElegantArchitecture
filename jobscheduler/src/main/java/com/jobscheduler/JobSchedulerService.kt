package com.jobscheduler

import android.os.Handler
import android.os.Handler.Callback
import android.os.Message
import android.widget.Toast
import me.tatarka.support.job.JobParameters
import me.tatarka.support.job.JobService


/**
 * Created by lijun on 2019-08-23.
 */
class JobSchedulerService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        mJobHandler.sendMessage(Message.obtain(mJobHandler, 1, params))
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        mJobHandler.removeMessages(1)
        return false
    }

    private val mJobHandler = Handler(Callback { msg ->
        Toast.makeText(
            applicationContext,
            "JobService task running: ${Thread.currentThread().name}",
            Toast.LENGTH_SHORT
        ).show()
        if (msg.obj is JobParameters) {
            jobFinished(msg.obj as JobParameters, false)
        }
        true
    })
}