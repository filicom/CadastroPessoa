// Operações de CRUD (create, read, update, delete) na tabela "pessoa" de um banco de dados.

package com.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Herança da classe Dao
public class PessoaDao extends Dao {

    // Método para incluir uma pessoa no banco de dados
    public void incluirPessoa(Pessoa p) throws Exception {
        open(); // Abre a conexão com o banco de dados
        stmt = con.prepareStatement("insert into pessoa values(?,?,?)"); // Prepara o comando SQL
        stmt.setInt(1, p.getIdPessoa()); // Define o ID da pessoa
        stmt.setString(2, p.getNomePessoa()); // Define o nome da pessoa
        stmt.setString(3, p.getEmail()); // Define o email da pessoa
        stmt.execute(); // Executa o comando SQL
        stmt.close(); // Fecha o comando SQL
        close(); // Fecha a conexão com o banco de dados
    }

    // Método para alterar os dados de uma pessoa no banco de dados
    public void alterarPessoa(Pessoa p) throws Exception {
        open(); // Abre a conexão com o banco de dados
        stmt = con.prepareStatement("update Pessoa set nomepessoa = ?, email = ? where idPessoa = ?");
        stmt.setString(1, p.getNomePessoa()); // Define o novo nome da pessoa
        stmt.setString(2, p.getEmail()); // Define o novo email da pessoa
        stmt.setInt(3, p.getIdPessoa()); // Define o ID da pessoa
        stmt.execute(); // Executa o comando SQL
        stmt.close(); // Fecha o comando SQL
        close(); // Fecha a conexão com o banco de dados
    }

    // Método para excluir uma pessoa do banco de dados
    public void excluirPessoa(Pessoa p) throws Exception {
        open(); // Abre a conexão com o banco de dados
        stmt = con.prepareStatement("delete from Pessoa where idPessoa = ?");
        stmt.setInt(1, p.getIdPessoa()); // Define o ID da pessoa a ser excluída
        stmt.execute(); // Executa o comando SQL
        stmt.close(); // Fecha o comando SQL
        close(); // Fecha a conexão com o banco de dados
    }

    // Método para consultar uma pessoa individualmente pelo ID
    public Pessoa consultarPessoaIndividual(int cod) throws Exception {
        open(); // Abre a conexão com o banco de dados
        stmt = con.prepareStatement("select * from pessoa where idPessoa = ?");
        stmt.setInt(1, cod); // Define o ID da pessoa a ser consultada
        try {
            rs = stmt.executeQuery(); // Executa o comando SQL e armazena o resultado
        } catch (SQLException ex) {
            throw new Exception(ex); // Lança exceção em caso de erro
        } finally {
            System.out.println("Fechando a conexão com banco de dados no Finally");
            close(); // Fecha a conexão com o banco de dados
        }
        Pessoa p = null; // Inicializa a variável Pessoa
        if (rs != null && rs.next()) {
            p = new Pessoa(); // Cria uma nova instância de Pessoa
            p.setIdPessoa(rs.getInt("idPessoa")); // Define o ID da pessoa
            p.setNomePessoa(rs.getString("nomePessoa")); // Define o nome da pessoa
            p.setEmail(rs.getString("email")); // Define o email da pessoa
        }
        close(); // Fecha a conexão com o banco de dados
        return p; // Retorna o objeto Pessoa
    }

    // Método para listar todas as pessoas do banco de dados
    public List<Pessoa> ListarPessoas() {
        try {
            open(); // Abre a conexão com o banco de dados
            stmt = con.prepareStatement("select * from pessoa");
            rs = stmt.executeQuery(); // Executa o comando SQL e armazena o resultado
            List<Pessoa> listaPessoas = new ArrayList<>(); // Cria uma lista para armazenar as pessoas
            while (rs.next()) {
                Pessoa p = new Pessoa(); // Cria uma nova instância de Pessoa
                p.setIdPessoa(rs.getInt("idPessoa")); // Define o ID da pessoa
                p.setNomePessoa(rs.getString("nomePessoa")); // Define o nome da pessoa
                p.setEmail(rs.getString("email")); // Define o email da pessoa
                listaPessoas.add(p); // Adiciona a pessoa na lista
            }
            close(); // Fecha a conexão com o banco de dados
            return listaPessoas; // Retorna a lista de pessoas
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Imprime a mensagem de erro
            return null; // Retorna null em caso de erro
        }
    }
}
