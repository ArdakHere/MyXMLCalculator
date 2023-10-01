package com.example.myxmlcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    private val model = CalculatorModel()
    private val controller = CalculatorController(model)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textField = findViewById<EditText>(R.id.textView)

        val ACbutton = findViewById<Button>(R.id.button11)
        val Cbutton = findViewById<Button>(R.id.button12)
        val percentButton = findViewById<Button>(R.id.button13)
        val divideButton = findViewById<Button>(R.id.button14)

        val sevenButton = findViewById<Button>(R.id.button21)
        val eightButton = findViewById<Button>(R.id.button22)
        val nineButton = findViewById<Button>(R.id.button23)
        val xButton = findViewById<Button>(R.id.button24)

        val fourButton = findViewById<Button>(R.id.button31)
        val fiveButton = findViewById<Button>(R.id.button32)
        val sixButton = findViewById<Button>(R.id.button33)
        val negativeButton = findViewById<Button>(R.id.button34)

        val oneButton = findViewById<Button>(R.id.button41)
        val twoButton = findViewById<Button>(R.id.button42)
        val threeButton = findViewById<Button>(R.id.button43)
        val plusButton = findViewById<Button>(R.id.button44)

        val zeroButton = findViewById<Button>(R.id.button51)
        val decimalButton = findViewById<Button>(R.id.button52)
        val equalButton = findViewById<Button>(R.id.button53)

        ACbutton.setOnClickListener(){
            val currentText = textField.text.toString()

            if(currentText == "Error"){
                textField.text.clear()
            } else if(currentText != "Error" && !currentText.isEmpty()){
                // Remove the last character

                val modifiedText = currentText.substring(0, currentText.length - 1)

                // Set the modified text back to the EditText
                textField.setText(modifiedText)
            } else if (currentText.isEmpty()){

            }

        }
        Cbutton.setOnClickListener(){
            textField.text.clear()
        }

        // percent button?

        divideButton.setOnClickListener(){
            textField.text.append("/")
        }

        // 2nd ROW

        sevenButton.setOnClickListener(){
            textField.text.append("7")
        }

        eightButton.setOnClickListener(){
            textField.text.append("8")
        }
        nineButton.setOnClickListener(){
            textField.text.append("9")
        }
        xButton.setOnClickListener(){
            textField.text.append("x")
        }

        // 3rd ROW

        fourButton.setOnClickListener(){
            textField.text.append("4")
        }
        fiveButton.setOnClickListener(){
            textField.text.append("5")
        }
        sixButton.setOnClickListener(){
            textField.text.append("6")
        }
        negativeButton.setOnClickListener(){
            textField.text.append("-")
        }

        oneButton.setOnClickListener(){
            textField.text.append("1")
        }
        twoButton.setOnClickListener(){
            textField.text.append("2")
        }
        threeButton.setOnClickListener(){
            textField.text.append("3")
        }
        plusButton.setOnClickListener(){
            textField.text.append("+")
        }

        zeroButton.setOnClickListener(){
            textField.text.append("0")
        }
        decimalButton.setOnClickListener(){
            textField.text.append(".")
        }

        equalButton.setOnClickListener(){
            val value = textField.text.toString()
            textField.text.clear()
            textField.setText(controller.onButtonPressed(value))
        }
    }
}