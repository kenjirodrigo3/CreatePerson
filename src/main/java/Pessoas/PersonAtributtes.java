package Pessoas;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class PersonAtributtes {

    private String nome;

    private String cpf;

    private String Endereco;

    public PersonAtributtes(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }


}
