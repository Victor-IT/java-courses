package com.vitkulov.lesson_08;

import com.vitkulov.lesson_08.exceptions.ClientException;
import com.vitkulov.lesson_08.exceptions.PetException;
import com.vitkulov.lesson_08.exceptions.UserException;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ClinicTest {
    private final Clinic clinic = new Clinic();

    @Test
    public void addClient() throws ClientException {
        Client client = new Client("Ivan");
        Client client2 = new Client("Peter");
        Client client3 = new Client("Ivan");

        clinic.addClient(client);
        clinic.addClient(client2);
        clinic.addClient(client3);

        Client result = clinic.getClientById(1);
        assertThat(result.equals(client), is(true));
        assertThat(result.equals(client3), is(false));
    }

    @Test(expected = ClientException.class)
    public void addClientShouldThrowException() throws ClientException {
        Client client = new Client("Ivan");

        clinic.addClient(client);
        clinic.addClient(client); // trying to add same client already exist

        Client result = clinic.getClientById(1);
        assertThat(result.equals(client), is(true));
    }

    @Test
    public void addPet() throws UserException {
        Client client = new Client("Ivan");
        Pet dog = new Dog("Dogie");
        clinic.addClient(client);
        clinic.addPet(1, dog);

        Client resultClient = clinic.getClientById(1);
        Pet resultPet = resultClient.getPetById(1);
        assertThat(resultClient.getName(), is("Ivan"));
        assertThat(resultPet.equals(dog), is(true));
    }

    @Test(expected = PetException.class)
    public void addPetShouldThrowException() throws UserException {
        Client client = new Client("Ivan");
        Pet dog = new Dog("Dogie");
        clinic.addClient(client);
        clinic.addPet(1, dog);
        clinic.addPet(1, dog); // trying to add same pet to client already exist

        Client resultClient = clinic.getClientById(1);
        Pet resultPet = resultClient.getPetById(1);
        assertThat(resultClient.getName(), is("Ivan"));
        assertThat(resultPet.equals(dog), is(true));
    }

    @Test
    public void editClient() throws ClientException {
        Client client = new Client("Ivan");
        clinic.addClient(client);
        Client result = clinic.getClientById(client.getId());
        assertThat(result.equals(client), is(true));

        result.setName("Pavel");
        clinic.editClient(result);
        assertThat(result.equals(client), is(true));
    }

    @Test
    public void editPet() throws UserException {
        Client client = new Client("Ivan");
        Pet pet = new Dog("Dogie");
        clinic.addClient(client);
        clinic.addPet(client.getId(), pet);

        Pet result = clinic.getClientById(client.getId()).getPetById(1);
        result.setName("Tuzik");
        assertThat(result.equals(pet), is(true));

        Pet pet2 = new Dog("Rokie");
        pet2.setId(1);
        clinic.editPet(client.getId(), pet2);

        Pet result2 = clinic.getClientById(client.getId()).getPetById(1);
        assertThat(result2.equals(pet2), is(true));
        assertThat(result == result2, is(false));
    }

    @Test
    public void deleteClient() throws ClientException {
        Client client = new Client("Ivan");
        clinic.addClient(client);

        Client result = clinic.getClientById(1);
        assertThat(result.getName(), is("Ivan"));

        clinic.deleteClient(1);
        Client result2 = clinic.getClientById(1);
        assertThat(result2, is(nullValue()));
    }

    @Test
    public void deletePet() throws UserException {
        Client client = new Client("Ivan");
        Pet pet = new Dog("Gray");
        clinic.addClient(client);
        clinic.addPet(1, pet);

        Pet result = clinic.getClientById(1).getPetById(1);
        assertThat(result.equals(pet), is(true));

        clinic.deletePet(client.getId(), 1);
        Pet result2 = clinic.getClientById(1).getPetById(1);
        assertThat(result2, is(nullValue()));
    }

    @Test
    public void searchClientByName() throws ClientException {
        Client client = new Client("Ivan");
        clinic.addClient(client);

        assertThat(clinic.getClients().contains(client), is(true));

        Collection<Client> clients = clinic.searchClientByName("Ivan");
        assertThat(clients.contains(client), is(true));
    }

    @Test
    public void searchPetByName() throws UserException {
        Client client = new Client("Ivan");
        Pet pet = new Dog("Gray");
        clinic.addClient(client);
        clinic.addPet(client.getId(), pet);

        List<Pet> petList = clinic.getClientById(client.getId()).getPetList();
        assertThat(petList.contains(pet), is(true));

        Collection<Client> clients = clinic.searchPetByName("Gray");
        assertThat(clients.contains(client), is(true));
    }

    @Test
    public void getClients() throws ClientException {
        Client client1 = new Client("Ivan");
        Client client2 = new Client("Victor");
        clinic.addClient(client1);
        clinic.addClient(client2);

        Collection<Client> result = clinic.getClients();
        assertThat(result.size(), is(2));
    }

    @Test
    public void getClientById() throws ClientException {
        Client client1 = new Client("Ivan");
        Client client2 = new Client("Victor");
        clinic.addClient(client1);
        clinic.addClient(client2);

        Client result = clinic.getClientById(2);
        assertThat(result.equals(client2), is(true));
    }

}