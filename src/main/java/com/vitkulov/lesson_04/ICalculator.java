package com.vitkulov.lesson_04;

public interface ICalculator {

    double getResult();

    /**
     * Adds two numbers
     *
     * @param first  first number
     * @param second second number
     */
    void add(double first, double second);


    /**
     * Multiplies two numbers
     *
     * @param first  first number
     * @param second second number
     */
    void multiply(double first, double second);

    /**
     * Subtracts the second number from the first
     *
     * @param first  first number
     * @param second second number
     */
    void subtract(double first, double second);

    /**
     * Divides the first number by the second. Throws exception if second number is 0
     *
     * @param first  first number
     * @param second second number
     */
    void divide(double first, double second);

    /**
     * Raises the first number in the power of the second number.
     *
     * @param first  first number
     * @param second exponent number
     */
    void exponent(double first, double second);

    /**
     * Clears result variable
     */
    void clear();

    /**
     * Calculates result based on specified operation
     *
     * @param first     first number
     * @param operation operations + - * / ^
     * @param second    second number
     */
    void calc(String operation, double first, double second);
}
