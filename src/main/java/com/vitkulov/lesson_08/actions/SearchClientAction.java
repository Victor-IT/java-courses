package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;

public class SearchClientAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        String name = validator.getString("Enter client name : ");
        for (Client client : clinic.searchClientByName(name)) {
            System.out.println(client);
        }
    }

    @Override
    public String intro() {
        return String.format("%s - search client", this.key());
    }

    @Override
    public int key() {
        return 7;
    }
}
