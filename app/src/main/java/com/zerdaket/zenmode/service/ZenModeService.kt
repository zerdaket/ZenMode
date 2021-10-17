package com.zerdaket.zenmode.service

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.*
import android.service.notification.ConditionProviderService
import android.util.Log
import com.zerdaket.zenmode.app
import com.zerdaket.zenmode.observer.ZenModeObserver
import com.zerdaket.zenmode.observer.ZenModeScheduleObserver
import java.lang.ref.WeakReference

/**
 * @author zerdaket
 * @date 2021/3/28 4:17 PM
 */
class ZenModeService: ConditionProviderService() {

    companion object {
        private const val TAG = "ZenModeService"
        private const val MSG_UNBIND = 1
        private var handler : ZenHandler? = null

        fun isAlive() = handler != null

        fun bind() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val componentName = ComponentName(app.packageName, ZenModeService::class.java.name)
                requestRebind(componentName)
            }
        }

        fun unbind() {
            if (isAlive()) {
                handler?.obtainMessage(MSG_UNBIND)?.sendToTarget()
            }
        }
    }

    private val zenModeObserver = ZenModeObserver()
    private val zenModeScheduleObserver = ZenModeScheduleObserver()

    override fun onCreate() {
        super.onCreate()
        zenModeObserver.register(this)
        zenModeScheduleObserver.register(this)
        handler = ZenHandler(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        zenModeObserver.unregister(this)
        zenModeScheduleObserver.unregister(this)
        handler?.removeCallbacksAndMessages(null)
        handler = null
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind")
        return super.onBind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onConnected() {
        // 获取已经添加的规则
    }

    override fun onSubscribe(conditionId: Uri) {
        // 新规则添加
    }

    override fun onUnsubscribe(conditionId: Uri) {
        // 规则移除
    }

    private class ZenHandler(service: ZenModeService) : Handler(Looper.getMainLooper()) {

        private val service = WeakReference(service).get()

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && msg.what == MSG_UNBIND) {
                service?.requestUnbind()
            }
        }
    }

}