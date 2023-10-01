package com.example.myxmlcalculator

class CalculatorController(private val model: CalculatorModel) {

    fun onButtonPressed(input: String) : String{
        val result = model.performCalculation(input)
        return result
    }
}