package Pessoas;

public class PersonAtributtes {

    private String nome;
    //CPF is a document in Brazil that is unique to a person
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
