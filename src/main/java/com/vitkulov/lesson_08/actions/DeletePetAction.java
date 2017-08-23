package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.IClinic;

public class DeletePetAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        int clientId = validator.getInt("Enter client ID : ");
        int petId = validator.getInt("Enter pet ID : ");
        clinic.deletePet(clientId, petId);
    }

    @Override
    public String intro() {
        return String.format("%s - delete pet", this.key());
    }

    @Override
    public int key() {
        return 6;
    }
}
