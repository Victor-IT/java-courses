package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;

import java.util.Collection;

public class SearchClientAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        String name = validator.getString("Enter client name : ");
        Collection<Client> clients = clinic.searchClientByName(name);
        if (clients.size() > 0) {
            for (Client client : clients) {
                System.out.println(client);
            }
        } else {
            System.out.println("No matches");
        }
    }

    @Override
    public String intro() {
        return String.format("%s - search client", this.key());
    }

    @Override
    public int key() {
        return 7;
    }
}
