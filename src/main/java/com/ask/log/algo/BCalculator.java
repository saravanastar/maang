package com.ask.log.algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BCalculator {

    public static void main(String[] args) {
        BCalculator bCalculator = new BCalculator();
        System.out.println(bCalculator.calculate("1-1+1"));
    }
    
    public int calculate(final String expression) {
        char[] inputArray = expression.toCharArray();
        Deque<Integer> numberStack = new LinkedList<>();
        Deque<String> operandStack = new LinkedList<>();
        for (int index = 0; index < inputArray.length; index++) {
            int number = 0;
            if (Character.isDigit(inputArray[index])) {
                while (index < inputArray.length && Character.isDigit(inputArray[index])) {
                    number = number * 10 + Character.getNumericValue(inputArray[index]);
                    index++;
                }
                numberStack.addLast(number);
                index--;
                continue;
            }

            if (inputArray[index] == '*' || inputArray[index] == '/') {
                char incoming = inputArray[index];
                while (!Character.isDigit(inputArray[index])) {
                    index++;
                }
                number = 0;
                if (Character.isDigit(inputArray[index])) {
                    while (index < inputArray.length && Character.isDigit(inputArray[index])) {
                        number = number * 10 + Character.getNumericValue(inputArray[index]);
                        index++;
                    }
                }
                    numberStack.addLast(calcSwitch(String.valueOf(incoming), numberStack.pollLast() , number));
                index--;
                continue;
            } else if (inputArray[index] == '+' || inputArray[index] == '-'){
                operandStack.addLast(String.valueOf(inputArray[index]));
            }

        }
        while (!operandStack.isEmpty()) {
            numberStack.push(calcSwitch(operandStack.pollFirst(), numberStack.pollFirst() , numberStack.pollFirst()));
        }
        return numberStack.pop();
    }

    private int calcSwitch(String operand, int number1, int number2) {
        switch (operand) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return 0;
    }
}
