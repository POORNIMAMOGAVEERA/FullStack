package learn.fullStack;

import com.google.inject.Inject;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import learn.proto.fullstack.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    private DatabaseConnector databaseConnector;

    @Inject
    public EmployeeService(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }


    @Override
    public void getAllEmployees(Empty request, StreamObserver<GetAllEmpRes> responseObserver) {
        try {
            List<Employee> employees = databaseConnector.getAllEmployees();

            GetAllEmpRes employeeList = GetAllEmpRes.newBuilder()
                    .addAllEmployees(employees)
                    .build();

            responseObserver.onNext(employeeList);
            responseObserver.onCompleted();
        } catch (SQLException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void createEmployee(CreateEmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {
        try {
            Employee employee = request.getEmployee();

            // Insert the employee into the database using the DatabaseConnector
            boolean success = databaseConnector.createEmployee(employee);

            if (success) {
                // Employee was successfully inserted
                EmployeeResponse response = EmployeeResponse.newBuilder()
                        .setStatus("Employee created successfully")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // Handle insertion failure
                responseObserver.onError(new RuntimeException("Employee creation failed"));
            }
        } catch (SQLException e) {
            responseObserver.onError(e);
        }
    }


    @Override
    public void updateEmployee(UpdateEmployeeRequest request, StreamObserver<UpdateEmployeeResponse> responseObserver) {

        try {
            boolean success = databaseConnector.updateEmployee(request);

            if (success) {
                // Employee was successfully updated
                Employee updatedEmployee = databaseConnector.getEmployee(request.getId());
                UpdateEmployeeResponse response = UpdateEmployeeResponse.newBuilder()
                        .setEmployee(updatedEmployee)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }else {
                // Handle update failure
                responseObserver.onError(new RuntimeException("Employee update failed"));
            }
        } catch (SQLException e) {
          // Rethrow it as a RuntimeException or another unchecked exception
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteEmployee(EmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {
        try {
            long employeeId = request.getId();

            // Delete the employee from the database using the DatabaseConnector
            boolean success = databaseConnector.deleteEmployee(employeeId);

            if (success) {
                // Employee was successfully deleted
                EmployeeResponse response = EmployeeResponse.newBuilder()
                        .setStatus("Employee deleted successfully")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // Handle delete failure (employee not found or other issues)
                responseObserver.onError(new RuntimeException("Employee delete failed"));
            }
        } catch (SQLException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getEmployee(EmployeeRequest request, StreamObserver<Employee> responseObserver) {
        try {
            long employeeId = request.getId();

            // Retrieve the employee from the database using the DatabaseConnector
            Employee employee = databaseConnector.getEmployee(employeeId);

            if (employee != null) {
                responseObserver.onNext(employee);
                responseObserver.onCompleted();
            } else {
                // Handle employee not found
                responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
            }
        } catch (SQLException e) {
            responseObserver.onError(e);
        }
    }

//public Employee fetchEmployeeById(long id, Connection connection) {
//        try {
//            String sql = "SELECT id, first_name, last_name, email_id FROM Employee WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setLong(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                return Employee.newBuilder()
//                        .setId(resultSet.getLong("id"))
//                        .setFirstName(resultSet.getString("first_name"))
//                        .setLastName(resultSet.getString("last_name"))
//                        .setEmailId(resultSet.getString("email_id"))
//                        .build();
//            } else {
//                throw new RuntimeException("Employee not found"); // Handle not found case
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
//
