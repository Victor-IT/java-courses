package com.vitkulov.lesson_04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Mock class for simulation user data inputs
 */
public class MockIO implements IO {

    private static final Logger LOG = LoggerFactory.getLogger(MockIO.class);
    private int index = 0;
    private final String[] answers; // like input thread where we will read data inputs one by one
    private final StringBuilder out = new StringBuilder();

    public MockIO(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String read() {
        return this.answers[index++];
    }

    @Override
    public void println(Object value) {
        this.out.append(value).append("\n");
    }

    public String getOut() {
        return this.out.toString();
    }
}
