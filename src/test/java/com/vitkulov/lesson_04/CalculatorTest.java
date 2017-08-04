package com.vitkulov.lesson_04;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculator class
 *
 * @author vitkulov
 * @since 04.08.2017
 */
public class CalculatorTest {

    private final double first = 4;
    private final double second = 2;
    private final Calculator calculator = new Calculator();
    private double result;

    @Test
    public void add() {
        calculator.add(first, second);
        result = calculator.getResult();
        assertThat(result, is(6d));
    }

    @Test
    public void subtract() {
        calculator.subtract(first, second);
        result = calculator.getResult();
        assertThat(result, is(2d));
    }

    @Test
    public void multiply() {
        calculator.multiply(first, second);
        result = calculator.getResult();
        assertThat(result, is(8d));
    }

    @Test
    public void divide() {
        calculator.divide(first, second);
        result = calculator.getResult();
        assertThat(result, is(2d));
    }

    @Test
    public void exponent() {
        calculator.exponent(first, second);
        result = calculator.getResult();
        assertThat(result, is(16d));
    }

    @Test
    public void calc() {
        String operator = "-";
        calculator.calc(operator, first, second);
        result = calculator.getResult();
        assertThat(result, is(2d));
    }

    @Test
    public void clear() {
        calculator.add(first, second);
        calculator.clear();
        result = calculator.getResult();
        assertThat(result, is(0d));
    }

}