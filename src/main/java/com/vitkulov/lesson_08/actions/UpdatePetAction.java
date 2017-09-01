package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;
import com.vitkulov.lesson_08.Pet;
import com.vitkulov.lesson_08.exceptions.ClientException;
import com.vitkulov.lesson_08.exceptions.PetException;

public class UpdatePetAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final Client client;
        try {
            client = clinic.getClientById(validator.getInt("Select client ID : "));
            Pet pet = client.getPetById(validator.getInt("Select pet ID :"));
            if (pet != null) {
                pet.setName(validator.getString("Enter pet name : "));
                client.editPet(pet);
            } else {
                throw new PetException("Pet not present");
            }
        } catch (ClientException | PetException e) {
            System.err.println(e.getMessage());
        }

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
