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
public class Calculator {

    private double result;

    public double getResult() {
        return result;
    }

    /**
     * Calculate addition
     *
     * @param first  first argument
     * @param second second argument
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Calculate subtraction
     *
     * @param first  first argument
     * @param second second argument
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Calculate multiplication
     *
     * @param first  first argument
     * @param second second argument
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Calculate division. Throws exception if second argument is 0
     *
     * @param first  first argument
     * @param second second argument
     */
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
     * Calculate exponentiation.
     *
     * @param first  base argument
     * @param second exponent argument
     */
    public void exponent(double first, double second) {
        double temp = 1;
        for (int i = 0; i < second; i++) {
            temp *= first;
        }
        this.result = temp;
    }

    /**
     * Calculate result based on specified operation
     *
     * @param first     first argument
     * @param operation operations + - * / ^
     * @param second    second argument
     */
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
