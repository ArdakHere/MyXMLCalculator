package com.example.myxmlcalculator

class CalculatorModel {
    val stackOfNumbers = ArrayDeque<Double>()
    val stackOfOperators = ArrayDeque<Char>()

    fun performCalculation(input: String): String {
        // Implement your calculation logic here

        var i = 0
        var markerNumberEnded = 0
        val charForNumbers = ""

        while (i < input.length) {
            if (input[i] > '0' && input[i] <= '9') {
                while (input[i] > '0' && input[i] <= '9') {
                    charForNumbers.plus(input[i])
                    markerNumberEnded = 1
                    i++
                }
                if (markerNumberEnded == 1) {
                    stackOfNumbers.addLast(charForNumbers.toInt().toDouble())
                }
            } else if (input[i] == 'x' || input[i] == '-' ||
                input[i] == '+' || input[i] == '/'
            ) {
                stackOfOperators.addLast(input[i])
                i++
            }

        }

        if (input != null) {
            val number1 = 0
            val number2 = 0
            while(!stackOfNumbers.isEmpty()){
                val number1 = stackOfNumbers.removeLast()  // 2
                val number2 = stackOfNumbers.removeLast()  // 3
                val currentOperator = stackOfOperators.removeFirst() // *

                if(currentOperator == '+'){
                    val sum = number1 + number2
                    val formattedResult = String.format("%.3f", sum)
                    stackOfNumbers.addLast(formattedResult.toDouble())
                }

                if(currentOperator == 'x'){
                    val sum = number1 * number2
                    val formattedResult = String.format("%.3f", sum)
                    stackOfNumbers.addLast(formattedResult.toDouble())
                }

                if(currentOperator == '-'){
                    val sum = number1 - number2
                    val formattedResult = String.format("%.3f", sum)
                    stackOfNumbers.addLast(formattedResult.toDouble())
                }

                if(currentOperator == '/'){
                    if (number2.toInt() != 0 || number2 != 0.0) {
                        val quotient = number1 / number2
                        val formattedResult = String.format("%.3f", quotient)
                        stackOfNumbers.addLast(formattedResult.toDouble())
                    } else {
                        // Handle division by zero
                        return "Error"
                    }
                }
            }
            return number1.toString()

        } else {
            // Handle invalid input or expression here
            return "Error"
        }
        return ""
    }
}


/*
            when (operator) {
                '+' -> {
                    val sum = num1 + num2
                    val formattedResult = String.format("%.3f", sum)
                    return formattedResult
                }

                '-' -> {
                    val difference = num1 - num2
                    val formattedResult = String.format("%.3f", difference)
                    return formattedResult
                }

                'x' -> {
                    val product = num1 * num2
                    val formattedResult = String.format("%.3f", product)
                    return formattedResult
                }

                '/' -> {
                    if (num2 != 0.0) {
                        val quotient = num1 / num2
                        val formattedResult =
                            String.format("%.3f", quotient)
                        return formattedResult
                    } else {
                        // Handle division by zero
                        return "Error"
                    }
                }
            }
 */