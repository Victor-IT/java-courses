package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;

public class SearchPetAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        String name = validator.getString("Enter pet's name : ");
        for (Client client : clinic.searchPetByName(name)) {
            System.out.println(client);
        }
    }

    @Override
    public String intro() {
        return String.format("%s - search pet", this.key());
    }

    @Override
    public int key() {
        return 8;
    }
}
