package com.vitkulov.lesson_08;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Clinic implements IClinic {
    private final AtomicInteger clientIds = new AtomicInteger();
    private final AtomicInteger petIds = new AtomicInteger();
    private Map<Integer, Client> clients = new LinkedHashMap<>();

    @Override
    public void addClient(final Client client) {
        Client temp = this.clients.get(client.getId());

        if (temp != null) {
            System.err.println("Client exist!");
        } else {
            client.setId(clientIds.incrementAndGet());
            this.clients.put(client.getId(), client);
        }
    }

    @Override
    public void addPet(final int clientId, final Pet pet) {
        Client client = this.clients.get(clientId);
        Pet temp = client.getPetById(pet.getId());

        if (temp != null) {
            System.err.println("Pet exist!");
        } else {
            pet.setId(petIds.incrementAndGet());
            client.addPet(pet);
        }
    }

    @Override
    public void editClient(final Client client) {
        this.clients.put(client.getId(), client);
    }

    @Override
    public void editPet(final int clientId, final Pet pet) {
        this.clients.get(clientId).editPet(pet);
    }

    @Override
    public void deleteClient(final int clientId) {
        this.clients.remove(clientId);
    }

    @Override
    public void deletePet(final int clientId, final int petId) {
        this.getClientById(clientId).deletePet(petId);
    }

    @Override
    public Collection<Client> searchClientByName(String name) {
        List<Client> result = new ArrayList<>();
        for (Client client : this.clients.values()) {
            if (client.getName().contains(name)) {
                result.add(client);
            }
        }
        return result;
    }

    @Override
    public Collection<Client> searchPetByName(String name) {
        List<Client> result = new ArrayList<>();
        for (Client client : this.clients.values()) {
            for (Pet pet : client.getPetList()) {
                if (pet.getName().contains(name)) {
                    result.add(client);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<Client> getClients() {
        return new ArrayList<>(this.clients.values());
    }

    @Override
    public Client getClientById(int clientId) {
        return this.clients.get(clientId);
    }

}
