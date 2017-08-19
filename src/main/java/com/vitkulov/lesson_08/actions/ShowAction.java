package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.Client;
import com.vitkulov.lesson_08.IClinic;

public class ShowAction implements Action {
    @Override
    public void execute(IClinic clinic, Validator validator) {
        if (clinic.getClients().size() > 0) {
            for (Client client : clinic.getClients()) {
                System.out.println(client);
            }
        } else {
            System.out.println("No clients.");
        }
    }

    @Override
    public String intro() {
        return String.format("%s - show clients", this.key());
    }

    @Override
    public int key() {
        return 0;
    }
}
