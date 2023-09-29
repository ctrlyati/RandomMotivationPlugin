package app.ctrlyati.plugin.motivate.randommotivation.popup

import javax.swing.JPanel
import javax.swing.JTextPane

class NotifyPopup(private val text: String) : JPanel(){

    init {
        add(JTextPane().apply {
            text = this@NotifyPopup.text
        }, CENTER_ALIGNMENT)
    }


}