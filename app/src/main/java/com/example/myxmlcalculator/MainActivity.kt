package com.example.myxmlcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
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
            textField.text.drop(1)
        }
        Cbutton.setOnClickListener(){
            textField.text.clear()
        }

        // percent button?

        divideButton.setOnClickListener(){
            textField.text.toString().plus("/")
        }

        // 2nd ROW

        sevenButton.setOnClickListener(){
            textField.text.toString().plus("7")
        }

        eightButton.setOnClickListener(){
            textField.text.toString().plus("8")
        }
        nineButton.setOnClickListener(){
            textField.text.toString().plus("9")
        }
        xButton.setOnClickListener(){
            textField.text.toString().plus("X")
        }

        // 3rd ROW

        fourButton.setOnClickListener(){
            textField.text.toString().plus("4")
        }
        fiveButton.setOnClickListener(){
            textField.text.toString().plus("5")
        }
        sixButton.setOnClickListener(){
            textField.text.toString().plus("6")
        }
        negativeButton.setOnClickListener(){
            textField.text.toString().plus("-")
        }

        oneButton.setOnClickListener(){
            textField.text.toString().plus("1")
        }
        twoButton.setOnClickListener(){
            textField.text.toString().plus("2")
        }
        threeButton.setOnClickListener(){
            textField.text.toString().plus("3")
        }
        negativeButton.setOnClickListener(){
            textField.text.toString().plus("+")
        }

        zeroButton.setOnClickListener(){
            textField.text.toString().plus("0")
        }
        decimalButton.setOnClickListener(){
            textField.text.toString().plus(".")
        }
        equalButton.setOnClickListener(){
            var i = 0
            var num1 = 0
            var num2 = 0
            if(textField.text.contains("+")){

                while(textField.text.get(i)!='+'){
                    num1.plus(textField.text.get(i).code)
                }
                i++
                while(i<textField.length()){
                    num2.plus(textField.text.get(i).code)
                }
                textField.setText(num1+num2)
            }
        }

    }
}