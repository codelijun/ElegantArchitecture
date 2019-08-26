package com.elegant.architecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jobscheduler.JobSchedulerTestActivity
import com.mvpplus.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mvp_plus_button.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MVPActivity::class.java
                )
            )
        }
        job_scheduler_button.setOnClickListener {
            startActivity(Intent(this, JobSchedulerTestActivity::class.java))
        }
    }
}