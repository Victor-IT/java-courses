package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;
import com.vitkulov.lesson_08.exceptions.ClientException;

public class CreateClientAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final String name = validator.getString("Enter client name : ");
        final Client client = new Client();
        client.setName(name);
        try {
            clinic.addClient(client);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String intro() {
        return String.format("%s - create client", this.key());
    }

    @Override
    public int key() {
        return 1;
    }
}
