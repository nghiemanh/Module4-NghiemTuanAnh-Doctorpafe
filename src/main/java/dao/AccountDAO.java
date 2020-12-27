package dao;


import java.sql.*;

public class AccountDAO {
    private static final String CHECK_LOGIN = "select * from account where username = ? and password = ?";

    private static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/doctor";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean checkLogin(String username, String password) throws SQLException {
        boolean isValid = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            } else {
                isValid = false;
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}

