package com.zerdaket.zenmode.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings

/**
 * @author zerdaket
 * @date 2021/3/28 5:34 PM
 */
class ZenBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        intent ?: return
        when (intent.action) {
            Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS -> {}
        }
    }

}