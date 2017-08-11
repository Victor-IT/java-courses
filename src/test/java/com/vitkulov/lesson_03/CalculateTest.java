package com.vitkulov.lesson_03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Testing simple calculator
 *
 * @author vitkulov
 * @since 04.08.2017
 */
public class CalculateTest {
    @Test
    public void whenPassArgToAddItShouldReturnSum() {
        final Calculate calc = new Calculate();
        final double result = calc.add(2, 3);
        assertThat(result, is(5d));
    }

    @Test
    public void whenPassArgsToSubtractItShouldReturnSubtraction() {
        final Calculate calc = new Calculate();
        final double result = calc.subtract(2, 3);
        assertThat(result, is(-1d));
    }

    @Test
    public void whenPassArgsToMultiplyItShouldReturnMultiplication() {
        final Calculate calc = new Calculate();
        final double result = calc.multiply(2, 3);
        assertThat(result, is(6d));
    }

    @Test
    public void whenPassArgsToDivideItShouldReturnDivision() {
        final Calculate calc = new Calculate();
        final double result = calc.divide(6, 3);
        assertThat(result, is(2d));
    }

    @Test
    public void whenPassArgsToPowItShouldReturnExponent() {
        final Calculate calc = new Calculate();
        final double result = calc.pow(2, 3);
        assertThat(result, is(8d));
    }

}