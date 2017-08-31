package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.MockIO;
import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.Clinic;
import com.vitkulov.lesson_08.Pet;
import com.vitkulov.lesson_08.exceptions.ClientException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreatePetActionTest {
    @Test
    public void execute() throws ClientException {
        Action createPetAction = new CreatePetAction();
        MockIO mockIO = new MockIO(new String[]{"1", "1", "Gray"});
        Clinic clinic = new Clinic();
        clinic.addClient(new Client("Ivan"));

        createPetAction.execute(clinic, new Validator(mockIO));
        Pet result = clinic.getClientById(1).getPetById(1);
        assertThat(result.getName(), is("Gray"));
    }

}