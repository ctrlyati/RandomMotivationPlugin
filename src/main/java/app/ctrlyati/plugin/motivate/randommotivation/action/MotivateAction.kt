package app.ctrlyati.plugin.motivate.randommotivation.action

import app.ctrlyati.plugin.motivate.randommotivation.service.MainService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class MotivateAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        val editor = e.dataContext.getData(CommonDataKeys.EDITOR)
        editor?.let { letEditor ->
            val cadet = letEditor.caretModel
            val document = letEditor.document
            if (document.isWritable) {
                val line = document.getLineNumber(cadet.offset)
                val eol = document.getLineEndOffset(line)
                WriteCommandAction.runWriteCommandAction(e.project) {

                    val mainService = MainService.getInstance()
                    val quotes = mainService.state.quotes.orEmpty()

                    document.insertString(eol, " // ${quotes.random()}") 
                } 

            }
        }
    }
}