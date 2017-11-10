package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.MockIO;
import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Clinic;
import com.vitkulov.lesson_08.exceptions.ClientException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreateClientActionTest {
    Action createClient = new CreateClientAction();
    MockIO mock = new MockIO(new String[]{"Ivan"});
    Clinic clinic = new Clinic();
    
    @Test
    public void execute() throws ClientException {
        createClient.execute(clinic, new Validator(mock));
        String result = clinic.getClientById(1).getName();
        assertThat(result, is("Ivan"));
    }

}