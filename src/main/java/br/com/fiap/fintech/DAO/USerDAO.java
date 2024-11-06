package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.User;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class USerDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "rootpasswordgiven";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
            + " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =4";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public USerDAO() {
    }

//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = ConnectionFactory.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        // Using try-with-resources to avoid closing resources (boilerplate code)
        List<User> users = new ArrayList<>();
        ResultSet rs = null; // Declare ResultSet outside of try

        // Step 1: Establishing a Connection
        try (Connection connection = ConnectionFactory.getConnection();
             // Step 2: Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {

            System.out.println("Executing query: " + SELECT_ALL_USERS);

            // Step 3: Execute the query
            rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object
            if (!rs.next()) {
                System.out.println("Not found.");
            } else {
                do {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");

                    // Create a User object and add it to the list
                    users.add(new User(id, name, email, country));

                    // Print user details to console
                    System.out.println("User ID: " + id + ", Name: " + name + ", Email: " + email + ", Country: " + country);
                } while (rs.next());
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            // Close the ResultSet if it's not null
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
            }
        }

        // Return the list of users
        return users;
    }


    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            System.out.println("updated USer:"+statement);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}