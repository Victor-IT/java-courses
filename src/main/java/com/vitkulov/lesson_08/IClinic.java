package com.vitkulov.lesson_08;

import java.util.Collection;

public interface IClinic {
    void addClient(Client client);

    void addPet(int id, Pet pet);

    void editClient(Client client);

    void editPet(int clientId, Pet pet);

    void deleteClient(int id);

    void deletePet(int clientId, int petId);

    /**
     * Get client list with defined name
     * @param name string for search
     * @return collection of clients
     */
    Collection<Client> searchClientByName(String name);

    /**
     * Get client list with pet has defined name
     * @param name string for search
     * @return collection of clients
     */
    Collection<Client> searchPetByName(String name);

    Collection<Client> getClients();

    Client getClientById(int clientId);
}
