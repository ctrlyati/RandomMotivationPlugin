package app.ctrlyati.plugin.motivate.randommotivation.action

import app.ctrlyati.plugin.motivate.randommotivation.popup.NotifyPopup
import app.ctrlyati.plugin.motivate.randommotivation.service.MainService
import com.intellij.codeInsight.hint.HintManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class MotivateHintAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        val editor = e.dataContext.getData(CommonDataKeys.EDITOR)
        editor?.let { letEditor ->
            val mainService = MainService.getInstance()
            val quotes = mainService.state.quotes
            val popup = NotifyPopup(quotes.random())
            HintManager.getInstance().showInformationHint(letEditor, popup)
        }

    }

}