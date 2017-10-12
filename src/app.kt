import View.MainView
import java.text.Normalizer
import javax.swing.JFrame

fun main(args: Array<String>) {
        val frame = JFrame("Alta de usuarios")
        frame.contentPane = MainView().panel1
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.pack()
        frame.isVisible = true

}