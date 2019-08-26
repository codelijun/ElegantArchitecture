package com.jobscheduler

import android.annotation.SuppressLint
import android.content.ComponentName
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.tatarka.support.job.JobInfo
import me.tatarka.support.job.JobScheduler


/**
 * Created by lijun on 2019-08-23.
 */
class JobSchedulerTestActivity : AppCompatActivity() {
    private var mJobScheduler: JobScheduler? = null

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler)
        mJobScheduler = JobScheduler.getInstance(this)
        val jobInfo: JobInfo =
            JobInfo.Builder(0, ComponentName(this, JobSchedulerService::class.java))
                .setMinimumLatency(1000)
                .setOverrideDeadline(9000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(true)
                .build()
        if (mJobScheduler?.schedule(jobInfo) ?: -1 <= 0) {
            //If something goes wrong
            Toast.makeText(applicationContext, "Something Goes Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mJobScheduler?.cancelAll()
    }
}