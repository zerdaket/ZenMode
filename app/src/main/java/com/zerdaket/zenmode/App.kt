package com.zerdaket.zenmode

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.provider.Settings
import com.zerdaket.zenmode.receiver.ZenBroadcastReceiver

/**
 * @author zerdaket
 * @date 2021/3/28 4:19 PM
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initInstance()
        registerReceiver(
            ZenBroadcastReceiver(),
            IntentFilter(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        )
    }

}

private lateinit var appContext: Context

private fun Application.initInstance() {
    appContext = this.applicationContext
}

val app: Context get() = appContext