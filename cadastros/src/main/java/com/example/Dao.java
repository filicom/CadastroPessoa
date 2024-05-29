package com.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao {

    Connection con;         // Conexao ao Banco de Dados
    PreparedStatement stmt;  // Acessa a Tabela ( insert, update, delete , select)
    ResultSet rs;            // Consulta a Tabela( select )
    CallableStatement call; //  Armazena um objeto CallableStatement para executar procedures e functions.

    public void open() throws Exception{    //abre a conexão com o db

        //Define a URL de conexao, o nome de usuario e a senha.
        String url = "jdbc:postgresql://localhost:5432/cadastros";
        String user = "postgres";
        String password = "admin";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch(SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o banco");
        }
    }

    public void close() throws Exception{        
        con.close();
    }
}
