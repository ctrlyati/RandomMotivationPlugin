package app.ctrlyati.plugin.motivate.randommotivation.action

import app.ctrlyati.plugin.motivate.randommotivation.popup.NotifyPopup
import app.ctrlyati.plugin.motivate.randommotivation.service.MainService
import com.intellij.codeInsight.hint.HintManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class AddMotivateAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        val editor = e.dataContext.getData(CommonDataKeys.EDITOR)
        editor?.let { letEditor ->
            val cadet = letEditor.caretModel.primaryCaret
            val textToAdd = cadet.selectedText ?: return
            MainService.getInstance().add(textToAdd)
//            quotes.add(textToAdd)
//            mainService.loadState(quotes)

            val popup = NotifyPopup("Motivational quote added!")
            HintManager.getInstance().showInformationHint(letEditor, popup)

        }


    }

}