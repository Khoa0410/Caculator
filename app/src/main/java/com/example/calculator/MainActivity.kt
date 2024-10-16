package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private var currentOperator = ""
    private var firstNumber = ""
    private var secondNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)

        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnCong: Button = findViewById(R.id.btnCong)
        val btnTru: Button = findViewById(R.id.btnTru)
        val btnNhan: Button = findViewById(R.id.btnNhan)
        val btnChia: Button = findViewById(R.id.btnChia)
        val btnBang: Button = findViewById(R.id.btnBang)
        val btnCE: Button = findViewById(R.id.btnCE)


        // Add listeners for number buttons
        btn0.setOnClickListener { appendNumber("0") }
        btn1.setOnClickListener { appendNumber("1") }
        btn2.setOnClickListener { appendNumber("2") }
        btn3.setOnClickListener { appendNumber("3") }
        btn4.setOnClickListener { appendNumber("4") }
        btn5.setOnClickListener { appendNumber("5") }
        btn6.setOnClickListener { appendNumber("6") }
        btn7.setOnClickListener { appendNumber("7") }
        btn8.setOnClickListener { appendNumber("8") }
        btn9.setOnClickListener { appendNumber("9") }

        // Add listeners for operators
        btnCong.setOnClickListener { setOperator("+") }
        btnTru.setOnClickListener { setOperator("-") }
        btnNhan.setOnClickListener { setOperator("*") }
        btnChia.setOnClickListener { setOperator("/") }

        // Delete button listener
        btnCE.setOnClickListener { reset(); textResult.text = "" }

        // Equal button listener
        btnBang.setOnClickListener { calculateResult() }
    }

    private fun appendNumber(number: String) {
        if (currentOperator.isEmpty()) {
            firstNumber += number
            textResult.text = firstNumber
        } else {
            secondNumber += number
            textResult.text = secondNumber
        }
    }

    private fun setOperator(operator: String) {
        if (firstNumber.isNotEmpty()) {
            currentOperator = operator
        }
    }

    private fun calculateResult() {
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
            val result = when (currentOperator) {
                "+" -> firstNumber.toInt() + secondNumber.toInt()
                "-" -> firstNumber.toInt() - secondNumber.toInt()
                "*" -> firstNumber.toInt() * secondNumber.toInt()
                "/" -> firstNumber.toInt() / secondNumber.toInt()
                else -> 0
            }

            textResult.text = result.toString()
            reset()
        }
    }

    private fun reset() {
        firstNumber = ""
        secondNumber = ""
        currentOperator = ""
    }
}
