package com.zerdaket.zenmode.zen

import android.app.AutomaticZenRule
import android.app.NotificationManager
import android.content.ComponentName
import android.net.Uri
import com.zerdaket.zenmode.app
import com.zerdaket.zenmode.service.ZenModeService

/**
 * @author zerdaket
 * @date 2021/3/29 11:35 PM
 */
class ZenRuleBuilder(private val name: String) {

    private var componentName = ComponentName(app.packageName, ZenModeService::class.java.name)
    private var condition: Uri? = null
    private var interruptionFilter = NotificationManager.INTERRUPTION_FILTER_ALL

    fun componentName(componentName: ComponentName) = apply {
        this.componentName = componentName
    }

    fun condition(condition: Uri) = apply {
        this.condition = condition
    }

    fun interruptionFilter(interruptionFilter: Int) = apply {
        this.interruptionFilter = interruptionFilter
    }

    fun build(): AutomaticZenRule {
        return AutomaticZenRule(
                name,
                componentName,
                condition,
                interruptionFilter,
                true
        )
    }
}