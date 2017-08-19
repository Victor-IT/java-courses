package com.vitkulov.lesson_08;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Clinic implements IClinic {
    private final AtomicInteger clientIds = new AtomicInteger();
    private final AtomicInteger petIds = new AtomicInteger();
    private final Map<Integer, Client> clients = new LinkedHashMap<>();

    @Override
    public void addClient(final Client client) {
        client.setId(clientIds.incrementAndGet());
        this.clients.put(client.getId(), client);
    }

    @Override
    public void addPet(final int id, final Pet pet) {
        pet.setId(petIds.incrementAndGet());
        this.clients.get(id).addPet(pet);
    }

    @Override
    public void editClient(final Client client) {
        this.clients.put(client.getId(), client);
    }

    @Override
    public void editPet(final int id, final Pet pet) {
        this.clients.get(id).editPet(pet);
    }

    @Override
    public void deleteClient(final int clientId) {
        this.clients.remove(this.getClientById(clientId));
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
    public Collection<Client> searchPetByNick(String nick) {
        List<Client> result = new ArrayList<>();
        for (Client client : this.clients.values()) {
            for (Pet pet : client.getPetList()) {
                if (pet.getName().contains(nick)) {
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
