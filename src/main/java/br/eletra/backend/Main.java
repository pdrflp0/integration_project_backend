package br.eletra.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/integration_project";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "87307944";

    public static void main(String[] args) {
        try {
            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Criar uma declaração SQL
            Statement statement = connection.createStatement();

            // Executar uma consulta SQL
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sua_tabela");

            // Processar o resultado da consulta
            while (resultSet.next()) {
                // Ler os dados do resultado
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                // Faça o que quiser com os dados
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

            // Fechar conexão, declaração e resultado
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
