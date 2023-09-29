package app.ctrlyati.plugin.motivate.randommotivation.setting

import app.ctrlyati.plugin.motivate.randommotivation.service.MainService
import com.intellij.icons.AllIcons
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.Panel
import com.intellij.ui.table.JBTable
import com.intellij.uiDesigner.core.GridLayoutManager
import com.intellij.util.containers.toArray
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.ListSelectionModel
import javax.swing.table.DefaultTableModel

class SettingComponent(quotes: List<String>) {

    private var listQuotes = quotes.toMutableList()
    val quotes: List<String>
        get() = listQuotes

    private val editPanel = JPanel()

    private val panel = JPanel(GridLayout(1, 1))
    val jComponent: JComponent
        get() = panel

    init {

        val quotes2d = quotes.map { arrayOf(it) }.toArray(arrayOf())
        val tableModel = DefaultTableModel(quotes2d, arrayOf("quote"))
        val table = JBTable(tableModel)
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)

        val contentPanel = JPanel(BorderLayout())

        val gridPanel = JPanel(GridLayout(1,1))
        gridPanel.add(JBScrollPane(table), BorderLayout.CENTER)


        val removeIcon = JButton(AllIcons.Actions.GC).apply {
            addActionListener {
                tableModel.removeRow(table.selectedRow)
                listQuotes = tableModel.dataVector.map { it.firstElement() as String }.toMutableList()

                println("list : $listQuotes")
                println("service list : ${MainService.getInstance().state}")
            }
        }

        editPanel.add(removeIcon)

        contentPanel.add(gridPanel, BorderLayout.CENTER)
        contentPanel.add(editPanel, BorderLayout.EAST)

        panel.add(contentPanel)

    }

    fun reset() {
        listQuotes = MainService.getInstance().state.quotes.orEmpty().toMutableList()
    }

}