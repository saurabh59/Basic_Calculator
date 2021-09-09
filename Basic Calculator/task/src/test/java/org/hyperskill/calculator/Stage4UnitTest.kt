package org.hyperskill.calculator

import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Stage4UnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)

    @Test
    fun testShouldCheckCalculatorSetsHint() {
        val activity = activityController.setup().get()
        val addButton = activity.findViewById<Button>(R.id.addButton)
        val clearButton = activity.findViewById<Button>(R.id.clearButton)
        val button1 = activity.findViewById<Button>(R.id.button1)
        val editText = activity.findViewById<EditText>(R.id.editText)

        clearButton.performClick()
        button1.performClick()
        addButton.performClick()
        val actualText = editText.hint.toString()


        val message = "Couldn't find the hint after entering the first value"
        assertEquals(message, "1", actualText)
    }

    @Test
    fun testShouldCheckCalculatorClearsHint() {
        val activity = activityController.setup().get()
        val addButton = activity.findViewById<Button>(R.id.addButton)
        val clearButton = activity.findViewById<Button>(R.id.clearButton)
        val button1 = activity.findViewById<Button>(R.id.button1)
        val editText = activity.findViewById<EditText>(R.id.editText)
        val equalButton = activity.findViewById<Button>(R.id.equalButton)

        clearButton.performClick()
        button1.performClick()
        addButton.performClick()
        button1.performClick()
        equalButton.performClick()
        clearButton.performClick()
        val actualText = editText.hint.toString()


        val message = "Looks like your app does not clear hint after clicking the Clear button."
        assertEquals(message, "0", actualText)
    }


    @Test
    fun testShouldCheckCalculatorReturnsTheIntAnswer() {
        val activity = activityController.setup().get()
        val button0 = activity.findViewById<Button>(R.id.button0)
        val button1 = activity.findViewById<Button>(R.id.button1)
        val button2 = activity.findViewById<Button>(R.id.button2)
        val button5 = activity.findViewById<Button>(R.id.button5)
        val clearButton = activity.findViewById<Button>(R.id.clearButton)
        val equalButton = activity.findViewById<Button>(R.id.equalButton)
        val addButton = activity.findViewById<Button>(R.id.addButton)
        val editText = activity.findViewById<EditText>(R.id.editText)

        clearButton.performClick()
        button1.performClick()
        button0.performClick()
        button0.performClick()
        addButton.performClick()
        button2.performClick()
        button5.performClick()
        equalButton.performClick()

        val actualText = editText.text.toString()


        val message = "Tried to add, got the wrong answer. Make sure the answer is not returned in Double when it is not necessary"
        assertEquals(message, "125", actualText)
    }

    @Test
    fun testShouldCheckCalculatorReturnsTheDoubleAnswer() {
        val activity = activityController.setup().get()
        val button0 = activity.findViewById<Button>(R.id.button0)
        val button1 = activity.findViewById<Button>(R.id.button1)
        val button2 = activity.findViewById<Button>(R.id.button2)
        val button5 = activity.findViewById<Button>(R.id.button5)
        val clearButton = activity.findViewById<Button>(R.id.clearButton)
        val equalButton = activity.findViewById<Button>(R.id.equalButton)
        val divideButton = activity.findViewById<Button>(R.id.divideButton)
        val editText = activity.findViewById<EditText>(R.id.editText)

        clearButton.performClick()
        button1.performClick()
        button2.performClick()
        button0.performClick()
        divideButton.performClick()
        button2.performClick()
        button5.performClick()
        equalButton.performClick()

        val actualText = editText.text.toString()


        val message = "Tried to divide, got the wrong answer. Make sure the answer is returned in Double when it is necessary"
        assertEquals(message, "4.8", actualText)
    }

}