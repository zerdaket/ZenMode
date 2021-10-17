package com.zerdaket.zenmode.observer

import android.content.Context
import android.database.ContentObserver
import android.provider.Settings
import android.util.Log
import com.zerdaket.zenmode.app

/**
 * @author zerdaket
 * @date 2021/7/8 12:14 上午
 */
class ZenModeScheduleObserver : ContentObserver(null) {

    private val uri = Settings.Global.getUriFor("zen_mode_shecdul_")

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        val switch = Settings.Global.getInt(app.contentResolver, "zen_mode_shecdul_", 0)
        Log.d("ZenModeScheduleObserver", "switch: $switch")
    }

    fun register(context: Context) {
        context.contentResolver.registerContentObserver(uri, false, this)
    }

    fun unregister(context: Context) {
        context.contentResolver.unregisterContentObserver(this)
    }

}