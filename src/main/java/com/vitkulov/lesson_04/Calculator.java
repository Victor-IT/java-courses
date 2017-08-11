package com.vitkulov.lesson_04;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Calculator realisation. Supports secondary usage of the previous calculation.
 *
 * @author vitkulov
 * @version 1.0
 * @since 27.07.2017
 */
public class Calculator implements ICalculator {

    /**
     * Store result of operations
     */
    private double result;

    @Override
    public double getResult() {
        return result;
    }

    /**
     * Adds two numbers
     *
     * @param first  first number
     * @param second second number
     */
    @Override
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Multiplies two numbers
     *
     * @param first  first number
     * @param second second number
     */
    @Override
    public void multiply(double first, double second) {
        this.result = first * second;
    }


    /**
     * Subtracts the second number from the first
     *
     * @param first  first number
     * @param second second number
     */
    @Override
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Divides the first number by the second. Throws exception if second number is 0
     *
     * @param first  first number
     * @param second second number
     */
    @Override
    public void divide(double first, double second) {
        if (second != 0d) {

            double d = first / second;

            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            String pattern = "##0.00";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String format = decimalFormat.format(d);

            this.result = Double.parseDouble(format);
        } else {
            throw new ArithmeticException("Could not div by 0");
        }
    }

    /**
     * Raises the first number in the power of the second number.
     *
     * @param first  first number
     * @param second exponent number
     */
    @Override
    public void exponent(double first, double second) {
        double temp = 1;
        for (int i = 0; i < second; i++) {
            temp *= first;
        }
        this.result = temp;
    }

    /**
     * Clears result variable
     */
    @Override
    public void clear() {
        this.result = 0;
    }

    /**
     * Calculates result based on specified operation
     *
     * @param first     first number
     * @param operation operations + - * / ^
     * @param second    second number
     */
    @Override
    public void calc(String operation, double first, double second) {
        switch (operation) {
            case "+":
                this.add(first, second);
                break;
            case "-":
                this.subtract(first, second);
                break;
            case "*":
                this.multiply(first, second);
                break;
            case "/":
                this.divide(first, second);
                break;
            case "^":
                this.exponent(first, second);
                break;
            default:
                throw new UnsupportedOperationException("Please, input correct parameters. Example: 1 + 2");
        }
    }
}
