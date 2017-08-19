package com.vitkulov.lesson_08;

import java.util.Collection;

public interface IClinic {
    void addClient(Client client);

    void addPet(int id, Pet pet);

    void editClient(Client client);

    void editPet(int id, Pet pet);

    void deleteClient(int id);

    void deletePet(int clientId, int petId);

    Collection<Client> searchClientByName(String name);

    Collection<Client> searchPetByNick(String nick);

    Collection<Client> getClients();

    Client getClientById(int clientId);
}
