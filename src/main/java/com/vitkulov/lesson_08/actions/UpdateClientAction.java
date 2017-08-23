package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;

public class UpdateClientAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final Client client = clinic.getClientById(validator.getInt("Select client ID"));
        client.setName(validator.getString("Enter client name : "));
        clinic.editClient(client);
    }

    @Override
    public String intro() {
        return String.format("%s - update client", this.key());
    }

    @Override
    public int key() {
        return 3;
    }
}
