package com.vitkulov.lesson_04;

/**
 * Console calculator.
 * Parses three arguments: 1 + 1
 *
 * @author vitkulov
 * @version 1.0
 * @since 28.07.2017
 */
public class ArgRunner {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calc(
                args[1],
                Double.parseDouble(args[0]),
                Double.parseDouble(args[2])
        );

        System.out.println(String.format(
                "%s %s %s = %s",
                args[0], args[1], args[2],
                calculator.getResult())
        );

    }
}
