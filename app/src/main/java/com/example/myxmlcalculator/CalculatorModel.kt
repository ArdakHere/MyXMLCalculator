package com.example.myxmlcalculator

import java.lang.StringBuilder
import java.util.Stack

class CalculatorModel {


    fun performCalculation(input: String): String {
        // Implement your calculation logic here
        return evaluateRPN(inputToRPN(input))
    }

    fun evaluateRPN(expression: String): String{

        val stack = Stack<Double>()
        val operators = setOf("+", "-", "x", "/")

        val tokens = expression.split(Regex("\\s+"))

        for (token in tokens) {
            if (!operators.contains(token)) {
                stack.push(token.toDouble())
            } else {
                val operand2 = stack.pop()
                val operand1 = stack.pop()
                when (token) {
                    "+" -> stack.push(operand1 + operand2)
                    "-" -> stack.push(operand1 - operand2)
                    "x" -> stack.push(operand1 * operand2)
                    "/" -> stack.push(operand1 / operand2)
                }
            }
        }
        return stack.pop().toString()
    }
    fun inputToRPN(infixExpression: String): String {
        val stack = ArrayDeque<Char>()
        val output = mutableListOf<String>() // Use a list of strings instead of characters
        val precedence = mapOf('+' to 1, '-' to 1, 'x' to 2, '/' to 2)
        var i = 0
        //Dekspan plus
        var exitLoopMarker = 0
        var multiDigitNumber = StringBuilder()

        while (i<infixExpression.length) {
            when {
                infixExpression[i].isDigit() || infixExpression[i] == '.' ||
                        (infixExpression[i] == '-' && i == 0)
                -> {
                    if(infixExpression[i] == '-' && i == 0){
                        multiDigitNumber.append(infixExpression[i])
                        i++
                    }
                    while(infixExpression[i].isDigit() || infixExpression[i]
                        == '.') {
                        if(infixExpression[i].isDigit()){
                            multiDigitNumber.append(infixExpression[i])
                        }
                        if(infixExpression[i] == '.'){
                            multiDigitNumber.append(infixExpression[i])
                        }

                        if(i+1 == infixExpression.length){
                            exitLoopMarker = 1
                            i++
                            break
                        } else {
                            i++
                        }
                    }
                    output.add(multiDigitNumber.toString()) // Add digits as separate
                    // strings
                    multiDigitNumber.clear()
                    continue
                }

                infixExpression[i] in "+-x/" -> {
                    while (stack.isNotEmpty() && stack.first() in "+-x/" &&
                        precedence[infixExpression[i]]!! <= precedence[stack.first()]!!) {
                        output.add(stack.removeFirst().toString()) // Add operators as separate strings
                    }
                    stack.addFirst(infixExpression[i])
                }
                infixExpression[i] == '(' -> {
                    stack.addFirst(infixExpression[i])
                }
                infixExpression[i] == ')' -> {
                    while (stack.isNotEmpty() && stack.first() != '(') {
                        output.add(stack.removeFirst().toString()) // Add operators as separate strings
                    }
                    if (stack.isNotEmpty() && stack.first() == '(') {
                        stack.removeFirst() // Remove the opening parenthesis
                    }
                }
                infixExpression[i].isWhitespace() -> {
                    // Ignore whitespace
                }
                else -> {
                    // Handle other characters (variables, functions, etc.) if needed
                }
            }
            i++
        }

        while (stack.isNotEmpty()) {
            output.add(stack.removeFirst().toString()) // Add remaining operators as separate strings
        }

        return output.joinToString(" ") // Join with spaces
    }
}


/*
val stack = ArrayDeque<Char>()
        val output = mutableListOf<String>() // Use a list of strings instead of characters
        val precedence = mapOf('+' to 1, '-' to 1, 'x' to 2, '/' to 2)

        for (char in infixExpression) {
            when {
                char.isDigit() -> {
                    output.add(char.toString()) // Add digits as separate strings

                }
                char in "+-x/" -> {
                    while (stack.isNotEmpty() && stack.first() in "+-x/" &&
                        precedence[char]!! <= precedence[stack.first()]!!) {
                        output.add(stack.removeFirst().toString()) // Add operators as separate strings
                    }
                    stack.addFirst(char)
                }
                char == '(' -> {
                    stack.addFirst(char)
                }
                char == ')' -> {
                    while (stack.isNotEmpty() && stack.first() != '(') {
                        output.add(stack.removeFirst().toString()) // Add operators as separate strings
                    }
                    if (stack.isNotEmpty() && stack.first() == '(') {
                        stack.removeFirst() // Remove the opening parenthesis
                    }
                }
                char.isWhitespace() -> {
                    // Ignore whitespace
                }
                else -> {
                    // Handle other characters (variables, functions, etc.) if needed
                }
            }
        }

        while (stack.isNotEmpty()) {
            output.add(stack.removeFirst().toString()) // Add remaining operators as separate strings
        }

        return output.joinToString(" ") // Join with spaces
    }
 */





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