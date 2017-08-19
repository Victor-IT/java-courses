package com.vitkulov.lesson_04;

import java.util.Scanner;

/**
 * Interactive calculator.
 * Supports user inputs
 *
 * @author vitkulov
 * @version 2.0
 * @since 03.08.2017
 */
public class InteractRunner {
    private final Calculator calculator;
    private final IO io;


    public InteractRunner(final Calculator calculator, final IO io) {
        this.calculator = calculator;
        this.io = io;
    }

    public void start() {
        boolean reuse = false;

        try (final Validator validator = new Validator(io)) {

            do {
                double first;
                double second;
                String operation;

                reuse = validator.compare("Do you want reuse last result? y/n:", "y");

                if (reuse) {
                    first = calculator.getResult();
                    System.out.println(first);
                } else {
                    first = validator.getDouble("Enter the first number:");
                }

                operation = validator.getOperator("Enter the operation symbol (+ - * / ^):");
                second = validator.getDouble("Enter the second number:");

                calculator.calc(operation, first, second);
                io.println(
                        String.format("%s %s %s = %s",
                                first, operation, second, calculator.getResult()
                        )
                );

            } while (validator.compare("Do you want to continue? y/n", "y"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new InteractRunner(
                new Calculator(),
                new ConsoleIO(new Scanner(System.in), System.out)
        ).start();
    }
}
