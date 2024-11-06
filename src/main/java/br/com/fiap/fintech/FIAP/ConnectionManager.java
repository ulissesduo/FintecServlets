package br.com.fiap.fintech.FIAP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "";
    private static final String SENHA = "";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
