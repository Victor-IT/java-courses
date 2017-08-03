package com.vitkulov.lesson_04;

import java.util.Scanner;

/**
 * Calculator. Supports user inputs
 *
 * @author vitkulov
 * @since 03.08.2017
 */
public class InteractRunner {
    private final Calculator calculator;


    private InteractRunner(final Calculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        boolean reuse = false;
        boolean next;
        Scanner scanner = new Scanner(System.in);

        do {
            double first;
            double second;
            String operation;

            if (reuse) {
                first = calculator.getResult();
                System.out.println(first);
            } else {
                System.out.println("Enter the first number:");
                first = scanner.nextDouble();
            }

            System.out.println("Enter the operation symbol (+ - * / ^):");
            operation = scanner.next();

            System.out.println("Enter the second number:");
            second = scanner.nextDouble();

            calculator.calc(first, operation, second);
            System.out.println(
                    String.format("%s %s %s = %s",
                            first, operation, second, calculator.getResult()
                    )
            );

            System.out.println("Do you want reuse the result or exit? y/n/e:");
            String temp = scanner.next();

            if (temp.toLowerCase().equals("y")) {
                reuse = true;
                next = true;
            } else if (temp.toLowerCase().equals("e")) {
                next = false;
            } else {
                reuse = false;
                next = true;
            }
        } while (next);

        scanner.close();
    }

    public static void main(String[] args) {
        new InteractRunner(new Calculator())
                .start();
    }

}
