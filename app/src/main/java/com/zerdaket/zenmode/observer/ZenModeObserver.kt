package com.zerdaket.zenmode.observer

import android.content.Context
import android.database.ContentObserver
import android.provider.Settings
import android.util.Log
import com.zerdaket.zenmode.app

/**
 * @author zerdaket
 * @date 2021/10/17 2:09 下午
 */
class ZenModeObserver : ContentObserver(null) {

    private val uri = Settings.Global.getUriFor("zen_mode")

    override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        val switch = Settings.Global.getInt(app.contentResolver, "zen_mode", 0)
        Log.d("ZenModeObserver", "switch: $switch")
    }

    fun register(context: Context) {
        context.contentResolver.registerContentObserver(uri, false, this)
    }

    fun unregister(context: Context) {
        context.contentResolver.unregisterContentObserver(this)
    }

}