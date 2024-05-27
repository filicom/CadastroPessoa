package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    public void open() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/cadastros",
                "postgres", "admin"
            );
            if(con != null) {
                System.out.println("Banco de dados conectado!");
            } else {
                System.out.println("Conexão falhou!");
            }
            // Código adicional para usar a conexão vai aqui
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
