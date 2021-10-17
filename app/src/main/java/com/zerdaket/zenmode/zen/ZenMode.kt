package com.zerdaket.zenmode.zen

import android.app.AutomaticZenRule
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.zerdaket.zenmode.app


/**
 * @author zerdaket
 * @date 2021/3/28 4:43 PM
 */
object ZenMode {

    private val notificationManager get() = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val isNotificationPolicyAccessGranted get() = notificationManager.isNotificationPolicyAccessGranted

    fun goToGranted() = app.startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

    fun addAutomaticZenRule(rule: AutomaticZenRule) = notificationManager.addAutomaticZenRule(rule)

    fun getAutomaticZenRule(id: String) = notificationManager.getAutomaticZenRule(id)

    fun getAutomaticZenRules() = notificationManager.automaticZenRules

    fun removeAutomaticZenRule(id: String) = notificationManager.removeAutomaticZenRule(id)

    fun updateAutomaticZenRule(id: String, rule: AutomaticZenRule) = notificationManager.updateAutomaticZenRule(id, rule)

}