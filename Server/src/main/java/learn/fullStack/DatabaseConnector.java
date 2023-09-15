package learn.fullStack;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import learn.proto.fullstack.Employee;
import learn.proto.fullstack.UpdateEmployeeRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DatabaseConnector {
    private final String jdbcUrl;
    private final String username;
    private final String password;

    @Inject
    public DatabaseConnector(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM Employee";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Employee employee = Employee.newBuilder()
                            .setId(resultSet.getLong("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setEmailId(resultSet.getString("email_id"))
                            .build();

                    employees.add(employee);
                }
            }
        }

        return employees;
    }

    public boolean createEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO Employee (id, first_name, last_name, email_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, employee.getId());
                preparedStatement.setString(2, employee.getFirstName());
                preparedStatement.setString(3, employee.getLastName());
                preparedStatement.setString(4, employee.getEmailId());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected == 1; // Return true if a single row was inserted
            }
        }
    }

    public boolean updateEmployee(UpdateEmployeeRequest updatedEmployee) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE Employee SET first_name = ?, last_name = ?, email_id = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, updatedEmployee.getFirstName());
                preparedStatement.setString(2, updatedEmployee.getLastName());
                preparedStatement.setString(3, updatedEmployee.getEmailId());
                preparedStatement.setLong(4, updatedEmployee.getId());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected == 1; // Return true if a single row was updated
            }
        }
    }

    public boolean deleteEmployee(long employeeId) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM Employee WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected == 1; // Return true if a single row was deleted
            }
        }
    }

    public Employee getEmployee(long employeeId) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "SELECT id, first_name, last_name, email_id FROM Employee WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, employeeId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Create an Employee object with the retrieved data
                        Employee employee = Employee.newBuilder()
                                .setId(resultSet.getLong("id"))
                                .setFirstName(resultSet.getString("first_name"))
                                .setLastName(resultSet.getString("last_name"))
                                .setEmailId(resultSet.getString("email_id"))
                                .build();

                        return employee;
                    } else {
                        return null;
                    }
                }
            }
        }
    }
}
