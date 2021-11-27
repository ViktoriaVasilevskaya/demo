package com.ifmo.lesson14.calc;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Добавьте поддержку переменных.
 * Синтаксис следующий.
 * Объявление переменной через символ '=':
 * x = 8
 *
 * Имя переменной не может быть числом.
 *
 * Использование в выражении вместо одного или двух аргументов:
 * x + 2
 * Результат: 10.
 *
 * Калькулятор должен выбрасывать соответствующие исключения с
 * подробными описаниями ошибок и как их исправить. Например,
 * если имя переменной не найдено или использовался неверный синтаксис.
 */
public class SimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");

                e.printStackTrace();
            }
        }
    }

    static int calculate(String line) throws CalcException {
        if (!line.contains("+") && !line.contains("-") && !line.contains("="))
            throw new CalcException("Expression must contain '+' or '-' or '=': " + line);

        String[] operands = line.split(" ");

        if (operands.length != 3)
            throw new CalcException("Expression must have only 3 operands separated with space (e.g. 2 + 4): " + line);

        OPERATOR operator = OPERATOR.parse(operands[1]);

        Map <String, Integer> map = new HashMap<>();
        int [] opp = new int[2];

        if (operator == OPERATOR.EQUALS) {
            String str = operands[0];
            if(str.matches("[a-zA-Z]+")){
                map.put(str, parseOperand(operands[2]));
            } else{
                throw new CalcException("Wrong operand, must be only string: " + str);
            }
            return parseOperand(operands[2]);
        } else{
            for (int i = 0; i < 2; i++) {
                if (map.containsKey(operands[i])) {
                    opp[i] = map.get(operands[i]);
                } else {
                    opp[0] = parseOperand(operands[0]);
                    opp[2] = parseOperand(operands[2]);
                }
            }
        }
        return operator.apply(opp[0], opp[2]);
    }

    private static int parseOperand(String string) throws CalcException {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new CalcException("Wrong operand, must be only integer number: " + string, e);
        }
    }

    private enum OPERATOR {
        PLUS, MINUS, EQUALS;

        int apply(int arg1, int arg2) throws CalcException {
            switch (this) {

                case PLUS:
                    return arg1 + arg2;

                case MINUS:
                    return arg1 - arg2;

            }

            throw new CalcException("Unsupported operator: " + this);
        }

        static OPERATOR parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;

                case "-":
                    return MINUS;

                case "=":
                    return EQUALS;
            }

            throw new CalcException("Incorrect operator: " + str);
        }

    }
}
