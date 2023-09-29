package app.ctrlyati.plugin.motivate.randommotivation.setting

import app.ctrlyati.plugin.motivate.randommotivation.service.MainService
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class SettingConfigurable : Configurable {

    private var settingComponent: SettingComponent = SettingComponent(MainService.getInstance().state.quotes.toMutableList())

    override fun createComponent(): JComponent {
        settingComponent.reset()
        return settingComponent.jComponent
    }

    override fun isModified(): Boolean {
        return settingComponent.quotes.size != MainService.getInstance().state.quotes.size
    }


    override fun apply() {
        MainService.getInstance().set(settingComponent.quotes)
    }

    override fun reset() {
        settingComponent.reset()
    }

    override fun getDisplayName(): String = "Random Motivation Setting"

}