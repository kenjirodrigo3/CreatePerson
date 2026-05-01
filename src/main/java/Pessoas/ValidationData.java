package Pessoas;

import Exceptions.Person.PersonDocumentationException;
import Exceptions.Person.NameException;

public class ValidationData {

    public void validarpessoa(PersonAtributtes personAtributtes) throws PersonDocumentationException, NameException {

        if (personAtributtes.getCPF() == null || personAtributtes.getCPF().length() != 11) {
            throw new PersonDocumentationException("CPF inválido. Deve conter 11 dígitos");
        }

        if (personAtributtes.getNome() == null || personAtributtes.getNome().trim().isBlank()) {
            throw new NameException("O campo: Nome não pode estar vazio");
        }
    }
}

