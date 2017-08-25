package com.vitkulov.lesson_08;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientTest {

    private Client client = new Client("Ivan");

    @Test
    public void addPet() {
        Pet pet = new Dog("Dogie");
        client.addPet(pet);
        List<Pet> pets = client.getPetList();

        assertThat(pets.get(0).equals(pet), is(true));
    }

    @Test
    public void getPetById() {
        Pet pet = new Dog("Scottie");
        pet.setId(3);
        client.addPet(pet);
        Pet resultPet = client.getPetById(3);

        assertThat(resultPet.equals(pet), is(true));
    }

    @Test
    public void editPet() {
        Pet pet = new Dog("Tuzik");
        pet.setId(1);
        client.addPet(pet);
        Pet result1 = client.getPetById(1);
        assertThat(result1.getName(), is("Tuzik"));

        pet.setName("Barsik");
        client.editPet(pet);
        Pet result2 = client.getPetById(1);
        assertThat(result2.getName(), is("Barsik"));

        assertThat(result1.getId(), is(1));
        assertThat(result2.getId(), is(1));
        assertThat(result1 == result2, is(true));
        assertThat(result2.equals(pet), is(true));
    }

    @Test
    public void deletePet() {
        Pet pet = new Dog("Chappy");
        pet.setId(1);
        client.addPet(pet);
        Pet result1 = client.getPetById(1);
        assertThat(result1.equals(pet), is(true));

        client.deletePet(1);
        Pet result2 = client.getPetById(1);
        assertThat(result2 == null, is(true));
    }

}