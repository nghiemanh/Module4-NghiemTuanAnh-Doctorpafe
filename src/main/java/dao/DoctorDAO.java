package dao;

import model.DoctoInfo;
import model.DoctorModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/doctor";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String SELECT_USER_BY_ID = "SELECT * FROM DOCTORLIST WHERE ID = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM DOCTORLIST";

    public DoctorDAO() {

    }

    protected Connection getConnection() {
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

    public DoctoInfo selectDoctor(int id) {
        DoctoInfo doctoInfo = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DoctoInfo doctor = new DoctoInfo();
                doctor.setId(resultSet.getLong("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setGender(resultSet.getBoolean("gender"));
                doctor.setNationality(resultSet.getString("nationality"));
                doctor.setAddress(resultSet.getString("address"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setEducation(resultSet.getString("education"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setHospital(resultSet.getString("hospital"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return doctoInfo;
    }


    public List<DoctorModel> selectAllDoctor() {
        List<DoctorModel> results = new ArrayList<>();
        //open connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DoctorModel doctor = new DoctorModel();
                doctor.setId(resultSet.getLong("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setGender(resultSet.getBoolean("gender"));
                doctor.setNationality(resultSet.getString("nationality"));
                doctor.setAddress(resultSet.getString("address"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setEducation(resultSet.getString("education"));
                doctor.setPosition(resultSet.getString("position"));
                doctor.setHospital(resultSet.getString("hospital"));
                results.add(doctor);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return results;
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
