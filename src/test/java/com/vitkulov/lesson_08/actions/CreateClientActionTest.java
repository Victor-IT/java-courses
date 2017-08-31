package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.MockIO;
import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Clinic;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CreateClientActionTest {
    @Test
    public void execute() {
        Action createClient = new CreateClientAction();
        MockIO mock = new MockIO(new String[]{"Ivan"});
        Clinic clinic = new Clinic();
        createClient.execute(clinic, new Validator(mock));

        String result = clinic.getClientById(1).getName();
        assertThat(result, is("Ivan"));
    }

}