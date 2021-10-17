package com.zerdaket.zenmode

import android.app.Application
import android.content.Context

/**
 * @author zerdaket
 * @date 2021/3/28 4:19 PM
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initInstance()
    }

}

private lateinit var appContext: Context

private fun Application.initInstance() {
    appContext = this.applicationContext
}

val app: Context get() = appContext