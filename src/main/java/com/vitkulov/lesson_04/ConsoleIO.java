package com.vitkulov.lesson_04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Class for reading input and print output in console.
 * Based on scanner class
 *
 * @author vitkulov
 * @version 1.0
 * @since 03.08.2017
 */
public class ConsoleIO implements IO {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleIO.class);
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleIO(final Scanner scanner, final PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    /**
     * Read next line on input
     *
     * @return string line
     */
    @Override
    public String read() {
        return this.scanner.next();
    }

    /**
     * Prints value to output
     *
     * @param value value to string
     */
    @Override
    public void print(Object value) {
        this.out.println(value);
    }

}
