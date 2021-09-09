package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button Declarations
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val addButton = findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subtractButton)
        val dotButton = findViewById<Button>(R.id.dotButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val divButton = findViewById<Button>(R.id.divideButton)
        val mulButton = findViewById<Button>(R.id.multiplyButton)
        val equalButton = findViewById<Button>(R.id.equalButton)

        // Edit Text Declaration
        val inputOutput = findViewById<EditText>(R.id.editText)

        //For calculations
        var result = 0F
        var operation = ""

        // Function to check if result is whole number
        fun isWhole(value: Float):Boolean {
            return value - value.toInt() == 0F
        }

        // Defining append buttons
        button0.setOnClickListener{
            when {
                inputOutput.text.toString() == "0" -> {
                    inputOutput.append("")
                }
                inputOutput.text.toString() == "-" -> {
                    inputOutput.append("")
                }
                else -> {
                    inputOutput.append("0")
                }
            }
        }
        button1.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("1")
            } else {
                inputOutput.append("1")
            }
        }
        button2.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("2")
            } else {
                inputOutput.append("2")
            }
        }
        button3.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("3")
            } else {
                inputOutput.append("3")
            }
        }
        button4.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("4")
            } else {
                inputOutput.append("4")
            }
        }
        button5.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("5")
            } else {
                inputOutput.append("5")
            }
        }
        button6.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("6")
            } else {
                inputOutput.append("6")
            }
        }
        button7.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("7")
            } else {
                inputOutput.append("7")
            }
        }
        button8.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("8")
            } else {
                inputOutput.append("8")
            }
        }
        button9.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("9")
            } else {
                inputOutput.append("9")
            }
        }
        addButton.setOnClickListener{
            operation = "+"
            result = inputOutput.text.toString().toFloat()
            inputOutput.setText("")
            if (isWhole(result)) {
                inputOutput.hint = result.toInt().toString()
            } else {
                inputOutput.hint = result.toString()
            }
        }
        subButton.setOnClickListener{
            if (inputOutput.text.toString() == "0") {
                inputOutput.setText("-")
            } else {
                result = inputOutput.text.toString().toFloat()
                operation = "-"
                inputOutput.setText("")
                if (isWhole(result)) {
                    inputOutput.hint = result.toInt().toString()
                } else {
                    inputOutput.hint = result.toString()
                }
            }
        }
        divButton.setOnClickListener{
            result = inputOutput.text.toString().toFloat()
            operation = "/"
            inputOutput.setText("")
            if (isWhole(result)) {
                inputOutput.hint = result.toInt().toString()
            } else {
                inputOutput.hint = result.toString()
            }
        }
        mulButton.setOnClickListener{
            result = inputOutput.text.toString().toFloat()
            operation = "*"
            inputOutput.setText("")
            if (isWhole(result)) {
                inputOutput.hint = result.toInt().toString()
            } else {
                inputOutput.hint = result.toString()
            }
        }
        clearButton.setOnClickListener{
            result = 0F
            inputOutput.setText("0")
            inputOutput.hint = "0"
        }
        dotButton.setOnClickListener{
            when {
                inputOutput.text.toString().contains(".") -> {
                    inputOutput.setText(inputOutput.text.toString())
                }
                inputOutput.text.toString() == "" -> {
                    inputOutput.append("0.")
                }
                inputOutput.text.toString() == "-" -> {
                    inputOutput.append("0.")
                }
                else -> {
                    inputOutput.append(".")
                }
            }
        }
        equalButton.setOnClickListener{
            when (operation) {
                "+" -> {
                    result += inputOutput.text.toString().toFloat()
                }
                "-" -> {
                    result -= inputOutput.text.toString().toFloat()
                }
                "*" -> {
                    result *= inputOutput.text.toString().toFloat()
                }
                "/" -> {
                    result /= inputOutput.text.toString().toFloat()
                }
            }
            if (isWhole(result)) {
                inputOutput.setText(result.toInt().toString())
            } else {
                inputOutput.setText(result.toString())
            }

        }

    }
}