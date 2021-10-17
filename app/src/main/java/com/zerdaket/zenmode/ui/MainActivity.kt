package com.zerdaket.zenmode.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zerdaket.zenmode.databinding.ActivityMainBinding
import com.zerdaket.zenmode.service.ZenModeService
import com.zerdaket.zenmode.zen.ZenMode

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initViews()
    }

    private fun initViews() {
        activityMainBinding.bind.setOnClickListener {
            if (ZenMode.isNotificationPolicyAccessGranted) {
                ZenModeService.bind()
            } else {
                ZenMode.goToGranted()
            }
        }
        activityMainBinding.unbind.setOnClickListener {
            ZenModeService.unbind()
        }
    }

}