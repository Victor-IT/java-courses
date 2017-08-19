package com.vitkulov.lesson_08.actions;

import com.vitkulov.lesson_04.Validator;
import com.vitkulov.lesson_08.IClinic;

public interface Action {

    void execute(final IClinic clinic, final Validator validator);

    String intro();

    int key();

}
