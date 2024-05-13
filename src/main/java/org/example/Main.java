package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();
        double result = ExpressionParser.evaluateExpression(expression);
        System.out.println("Результат: " + result);
    }
}