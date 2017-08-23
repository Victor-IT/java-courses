package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.IClinic;

public class DeleteClientAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        int clientId = validator.getInt("Enter client ID : ");
        clinic.deleteClient(clientId);
    }

    @Override
    public String intro() {
        return String.format("%s - delete client", this.key());
    }

    @Override
    public int key() {
        return 5;
    }
}
