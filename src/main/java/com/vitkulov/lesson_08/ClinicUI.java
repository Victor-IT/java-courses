package com.vitkulov.lesson_08;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.actions.Action;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClinicUI {
    private IClinic clinic;
    private Validator validator;
    private final Map<Integer, Action> actions = new ConcurrentHashMap<>();

    public ClinicUI(final IClinic clinic, final Validator validator) {
        this.clinic = clinic;
        this.validator = validator;
    }

    public void loadAction(final Action action) {
        this.actions.put(action.key(), action);
    }

    public void show() {
        this.intro();
        do {
            doAction(validator);
        } while (validator.compare("Do you want to continue? (y)", "y"));
    }

    private void intro() {
        System.out.println("Welcome to clinic");
        for (final Action action : this.actions.values()) {
            System.out.println(action.intro());
        }
    }

    private void doAction(final Validator validator) {
        this.actions.get(validator.getIntFromList("Enter operation : ", this.actions.keySet())
        ).execute(this.clinic, validator);
    }
}
