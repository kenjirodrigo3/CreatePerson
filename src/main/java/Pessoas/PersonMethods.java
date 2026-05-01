package Pessoas;

import DBConnection.DBEstablish;
import Exceptions.Person.PersonDocumentationException;
import Exceptions.Person.NameException;

import java.sql.*;


public class PersonMethods {

    // Create pearson
    public void AdicionarPessoas(PersonAtributtes personAtributtes) throws PersonDocumentationException, NameException, Exception {
        DBEstablish DBEstablish = new DBEstablish();
        Connection conexao = DBEstablish.EstablishConnection();
        final String CadastroPessoa = "INSERT INTO public.\"Pessoa\"(\"Nome\", \"CPF\") VALUES (?, ?)";
        if (conexao == null) {
            System.out.println("Error to connect to the Database");
            return;
        }

        ValidationData validationData = new ValidationData();
        validationData.validarpessoa(personAtributtes);

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(CadastroPessoa);
            preparedStatement.setString(1, personAtributtes.getNome());
            preparedStatement.setString(2, personAtributtes.getCPF());
            preparedStatement.executeUpdate();
            System.out.println("Pearson created Sucessfully ✅");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //Data Pearson update
    public void AtualizarPessoa(PersonAtributtes personAtributtes) throws NameException, PersonDocumentationException, Exception{
        DBEstablish DBEstablish = new DBEstablish();
        Connection conexao = DBEstablish.EstablishConnection();
        final String CadastroPessoa = "UPDATE public.\"Pessoa\" SET \"Nome\" = ?, \"CPF\" = ? WHERE \"CPF\" = ?";

        ValidationData validationData = new ValidationData();
        validationData.validarpessoa(personAtributtes);

        try {
            if (conexao != null) {
                PreparedStatement preparedStatement = conexao.prepareStatement(CadastroPessoa);
                preparedStatement.setString(1, personAtributtes.getNome());
                preparedStatement.setString(2, personAtributtes.getCPF());
                preparedStatement.setString(3, personAtributtes.getCPF());
                preparedStatement.executeUpdate();
                System.out.println("Person's data update sucessfully! ✅");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Deletar pessoas
    public void DeletarPessoa(PersonAtributtes personAtributtes) {
        DBEstablish DBEstablish = new DBEstablish();
        Connection conexao = DBEstablish.EstablishConnection();
        final String deletapessoa = "DELETE FROM public.\"Pessoa\" WHERE \"CPF\" = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(deletapessoa);
            preparedStatement.setString(1, personAtributtes.getCPF());
            preparedStatement.executeUpdate();
            System.out.println("Pessoa removida com sucesso!!️");
        } catch (Exception exception) {
            System.out.println("Erro: " + exception);
        }
    }

    // Consultar pessoas
    public void ConsultarPessoas() {
        DBEstablish DBEstablish = new DBEstablish();
        Connection conexao = DBEstablish.EstablishConnection();
        final String consultapessoa = "SELECT * FROM public.\"Pessoa\"";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(consultapessoa);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("Nome");
                String CPF = rs.getString("CPF");
                System.out.println("Nome: " + nome + " - CPF: " + CPF);
            }
        } catch (Exception exception) {
            System.out.println("Erro : " + exception);
        }
    }
}