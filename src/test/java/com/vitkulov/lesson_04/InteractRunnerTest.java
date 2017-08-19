package com.vitkulov.lesson_04;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class InteractRunnerTest {

    @Test
    public void whenTakePlusShouldSummarize() {
        MockIO mock = new MockIO(new String[]{"n", "1", "+", "1", "n"});
        new InteractRunner(
                new Calculator(),
                mock
        ).start();
        assertThat(mock.getOut().split("\n")[0], is("1.0 + 1.0 = 2.0"));
    }
}
