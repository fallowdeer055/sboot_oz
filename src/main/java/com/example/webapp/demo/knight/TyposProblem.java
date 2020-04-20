package com.example.webapp.demo.knight;

public class TyposProblem {


    public static void main(String[] args) {
        String input = "((((()()())(()())(((((()()()))()(((()(())))))()))()(())()())";

        System.out.println(calculate(input));

    }

    private static int calculate(String input) {

        int totalCounter = 0;
        int openingBrackets = 0;
        int closingBracketsBeforeNegative = 0;
        boolean negativeHappened = false;

        for (char c : input.toCharArray()) {

            if (c == '(') {
                totalCounter++;
                openingBrackets++;

            } else {
                totalCounter--;

                if (!negativeHappened) {
                    closingBracketsBeforeNegative++;
                }

                if (totalCounter < 0) {
                    negativeHappened = true;
                }

            }


        }

        if (totalCounter == 2) {
            return openingBrackets;
        } else if (totalCounter == -2) {
            return closingBracketsBeforeNegative;
        } else {
            return 0;
        }
    }

}
