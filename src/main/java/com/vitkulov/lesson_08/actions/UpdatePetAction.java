package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;
import com.vitkulov.lesson_08.Pet;

public class UpdatePetAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final Client client = clinic.getClientById(validator.getInt("Select client ID : "));
        Pet pet = client.getPetById(validator.getInt("Select pet ID :"));
        pet.setName(validator.getString("Enter pet name : "));
        client.editPet(pet);
    }

    @Override
    public String intro() {
        return String.format("%s - update pet", this.key());
    }

    @Override
    public int key() {
        return 4;
    }
}
