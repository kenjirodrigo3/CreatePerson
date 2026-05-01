package Principal;

import Exceptions.Person.PersonDocumentationException;
import Exceptions.Person.NameException;
import Pessoas.PersonMethods;
import Pessoas.PersonAtributtes;


public class Main {

    public static void main(String[] args) {
        //Criar pessoas
        PersonMethods personMethods = new PersonMethods();
        try{
            PersonAtributtes personAtributtes = new PersonAtributtes("","77777777777");
                personMethods.AdicionarPessoas(personAtributtes);
            } catch (PersonDocumentationException | NameException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }


    }


}