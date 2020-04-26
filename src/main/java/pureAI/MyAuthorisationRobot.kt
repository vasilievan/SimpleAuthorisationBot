package pureAI

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.event.InputEvent

object MyAuthorisationRobot {
    private const val ping = 120
    private const val delay = 900L

    fun doJob() {
        Thread.sleep(1500)
        val a = Robot()
        a.delay(1000)
        a.mouseMove(400, 50)
        rightMouseButton(a)
        a.mouseMove(450, 160)
        leftMouseButton(a)
        val defaultToolkit = Toolkit.getDefaultToolkit().systemClipboard
        val dataFlavor = DataFlavor.stringFlavor
        val text = defaultToolkit.getData(dataFlavor).toString()
        if ("dl.spbstu.ru" in text) {
            makeDelay()
            a.mouseMove(1850, 100)
            tripleClick(a)
            makeDelay()
            a.mouseMove(700, 450)
            tripleClick(a)
            makeDelay()
            a.mouseMove(970, 350)
            tripleClick(a)
            /* print login
            a.keyPressed(KeyEvent)
            a.keyRelease(KeyEvent)
            * */
            makeDelay()
            a.mouseMove(970, 430)
            tripleClick(a)
            // print password
            a.mouseMove(910, 510)
            tripleClick(a)
        }
    }

    private fun tripleClick(a: Robot) {
        leftMouseButton(a)
        leftMouseButton(a)
        leftMouseButton(a)
    }

    private fun makeDelay() {
        Thread.sleep(delay)
    }

    private fun leftMouseButton(a: Robot) {
        a.mousePress(InputEvent.BUTTON1_DOWN_MASK)
        a.delay(ping)
        a.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    }

    private fun rightMouseButton(a: Robot) {
        a.mousePress(InputEvent.BUTTON3_DOWN_MASK)
        a.delay(ping)
        a.mouseRelease(InputEvent.BUTTON3_DOWN_MASK)
    }
}