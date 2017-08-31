package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Cat;
import com.vitkulov.lesson_08.Dog;
import com.vitkulov.lesson_08.IClinic;
import com.vitkulov.lesson_08.Pet;
import com.vitkulov.lesson_08.exceptions.PetException;

import java.util.Arrays;

public class CreatePetAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        int clientId = validator.getInt("Enter client ID : ");
        int type = validator.getIntFromList("Select pet - 1. Dog, 2. Cat : ", Arrays.asList(1, 2));
        String petName = validator.getString("Enter pet name : ");
        Pet pet = type == 1 ? new Dog(petName) : new Cat(petName);
        try {
            clinic.addPet(clientId, pet);
        } catch (PetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String intro() {
        return String.format("%s - create pet", this.key());
    }

    @Override
    public int key() {
        return 2;
    }
}
