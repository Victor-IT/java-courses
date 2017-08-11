package com.vitkulov.lesson_04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Class for user data input validation.
 *
 * @author vitkulov
 * @version 1.0
 * @since 03.08.2017
 */
public class Validator implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(Validator.class);
    private final IO io;

    public Validator(final IO io) {
        this.io = io;
    }

    /**
     * Get number from input.
     * Repeats until input is correct
     *
     * @param message - prompt message
     * @return int number
     */
    public double getDouble(String message) {
        boolean invalid;
        do {
            try {
                System.out.println(message);
                return Double.parseDouble(this.io.read());
            } catch (NumberFormatException n) {
                invalid = true;
                LOG.error("Convert number error", n);
                System.out.println("Please enter the number.");
            }
        } while (invalid);
        throw new NumberFormatException();
    }

    /**
     * Get string from input.
     * Repeats until the string is equals to one of arithmetic operators
     *
     * @param message
     * @return
     */
    public String getOperator(String message) {

        boolean invalid;
        List<String> ops = Arrays.asList("+", "-", "*", "/", "^");
        String operator;
        do {
            System.out.println(message);
            operator = this.io.read();
            if (ops.contains(operator)) {
                return operator;
            } else {
                invalid = true;
                LOG.error("No such operator present");
                System.out.println("Please enter the correct operation symbol");
            }
        } while (invalid);
        throw new UnsupportedOperationException("No such operator present: " + operator);
    }

    /**
     * Compare input to predefined answer
     *
     * @param message - prompt message
     * @param answer  - predefined value to compare
     * @return boolean
     */
    public boolean compare(final String message, final String answer) {
        System.out.println(message);
        return answer.equals(io.read());
    }

    @Override
    public void close() throws Exception {
    }
}
