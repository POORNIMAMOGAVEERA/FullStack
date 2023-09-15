package learn.fullStack;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import junit.framework.TestCase;
import learn.proto.fullstack.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private DatabaseConnector databaseConnector;

    @Mock
    private StreamObserver<GetAllEmpRes> responseObserverAllEmployee;

    @Mock
    private StreamObserver<EmployeeResponse> responseObserverCreate;

    @Mock
    private StreamObserver<UpdateEmployeeResponse> responseObserverUpdate;

    @Mock
    private StreamObserver<EmployeeResponse> responseObserverDelete;

    @Mock
    private StreamObserver<Employee> responseObserverEmployee;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() throws SQLException {
        // Prepare a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.newBuilder().setId(1).setFirstName("John").setLastName("Doe").setEmailId("john@example.com").build());

        // Mock the behavior of the databaseConnector
        when(databaseConnector.getAllEmployees()).thenReturn(employees);

        // Invoke the getAllEmployees method
        Empty empty = Empty.newBuilder().build();
        employeeService.getAllEmployees(empty, responseObserverAllEmployee);

        // Capture the response and verify it
        ArgumentCaptor<GetAllEmpRes> responseCaptor = ArgumentCaptor.forClass(GetAllEmpRes.class);
        verify(responseObserverAllEmployee).onNext(responseCaptor.capture());
        verify(responseObserverAllEmployee).onCompleted();

        // Assert the captured response
        GetAllEmpRes response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals(1, response.getEmployeesCount());
        assertEquals(1, response.getEmployees(0).getId());
        assertEquals("John", response.getEmployees(0).getFirstName());
        assertEquals("Doe", response.getEmployees(0).getLastName());
        assertEquals("john@example.com", response.getEmployees(0).getEmailId());
    }

    @Test
    void testCreateEmployee() throws SQLException {
        // Prepare a CreateEmployeeRequest
        Employee employee = Employee.newBuilder()
                .setId(1)
                .setFirstName("John")
                .setLastName("Doe")
                .setEmailId("john@example.com")
                .build();

        CreateEmployeeRequest request = CreateEmployeeRequest.newBuilder()
                .setEmployee(employee)
                .build();

        // Mock the behavior of the databaseConnector
        when(databaseConnector.createEmployee(employee)).thenReturn(true);

        // Invoke the createEmployee method
        employeeService.createEmployee(request, responseObserverCreate);

        // Capture the response and verify it
        ArgumentCaptor<EmployeeResponse> responseCaptor = ArgumentCaptor.forClass(EmployeeResponse.class);
        verify(responseObserverCreate).onNext(responseCaptor.capture());
        verify(responseObserverCreate).onCompleted();

        // Assert the captured response
        EmployeeResponse response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals("Employee created successfully", response.getStatus());
    }

    @Test
    void testUpdateEmployee() throws SQLException {
        // Prepare an UpdateEmployeeRequest
        UpdateEmployeeRequest request = UpdateEmployeeRequest.newBuilder()
                .setId(1)
                .setFirstName("Updated John")
                .setLastName("Updated Doe")
                .setEmailId("updated.john@example.com")
                .build();

        // Mock the behavior of the databaseConnector
        when(databaseConnector.updateEmployee(request)).thenReturn(true);

        // Mock the behavior of getEmployee
        Employee updatedEmployee = Employee.newBuilder()
                .setId(1)
                .setFirstName("Updated John")
                .setLastName("Updated Doe")
                .setEmailId("updated.john@example.com")
                .build();
        when(databaseConnector.getEmployee(request.getId())).thenReturn(updatedEmployee);

        // Invoke the updateEmployee method
        employeeService.updateEmployee(request, responseObserverUpdate);

        // Capture the response and verify it
        ArgumentCaptor<UpdateEmployeeResponse> responseCaptor = ArgumentCaptor.forClass(UpdateEmployeeResponse.class);
        verify(responseObserverUpdate).onNext(responseCaptor.capture());
        verify(responseObserverUpdate).onCompleted();

        // Assert the captured response
        UpdateEmployeeResponse response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals(updatedEmployee, response.getEmployee());
    }
    @Test
    void testDeleteEmployeeSuccess() throws SQLException {
        // Prepare an EmployeeRequest for deletion
        EmployeeRequest request = EmployeeRequest.newBuilder().setId(1).build();

        // Mock the behavior of the databaseConnector
        when(databaseConnector.deleteEmployee(request.getId())).thenReturn(true);

        // Invoke the deleteEmployee method
        employeeService.deleteEmployee(request, responseObserverDelete);

        // Capture the response and verify it
        ArgumentCaptor<EmployeeResponse> responseCaptor = ArgumentCaptor.forClass(EmployeeResponse.class);
        verify(responseObserverDelete).onNext(responseCaptor.capture());
        verify(responseObserverDelete).onCompleted();

        // Assert the captured response
        EmployeeResponse response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals("Employee deleted successfully", response.getStatus());
    }

    @Test
    void testDeleteEmployeeFailure() throws SQLException {
        // Prepare an EmployeeRequest for deletion
        EmployeeRequest request = EmployeeRequest.newBuilder().setId(1).build();

        // Mock the behavior of the databaseConnector to simulate deletion failure
        when(databaseConnector.deleteEmployee(request.getId())).thenReturn(false);

        // Invoke the deleteEmployee method
        employeeService.deleteEmployee(request, responseObserverDelete);

        // Capture the response and verify it
        ArgumentCaptor<Throwable> errorCaptor = ArgumentCaptor.forClass(Throwable.class);
        verify(responseObserverDelete).onError(errorCaptor.capture());

        // Assert that the captured error is a RuntimeException
        Throwable error = errorCaptor.getValue();
        assertTrue(error instanceof RuntimeException);
        assertEquals("Employee delete failed", error.getMessage());

        // Verify that onCompleted was not called
        verify(responseObserverDelete, never()).onCompleted();
    }

    @Test
    void testGetEmployeeSuccess() throws SQLException {
        // Prepare an EmployeeRequest for retrieval
        EmployeeRequest request = EmployeeRequest.newBuilder().setId(1).build();

        // Mock the behavior of the databaseConnector to return a valid employee
        Employee expectedEmployee = Employee.newBuilder()
                .setId(1)
                .setFirstName("John")
                .setLastName("Doe")
                .setEmailId("john@example.com")
                .build();
        when(databaseConnector.getEmployee(request.getId())).thenReturn(expectedEmployee);

        // Invoke the getEmployee method
        employeeService.getEmployee(request, responseObserverEmployee);

        // Capture the response and verify it
        ArgumentCaptor<Employee> responseCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(responseObserverEmployee).onNext(responseCaptor.capture());
        verify(responseObserverEmployee).onCompleted();

        // Assert the captured response
        Employee response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals(expectedEmployee, response);
    }

    @Test
    void testGetEmployeeNotFound() throws SQLException {
        // Prepare an EmployeeRequest for retrieval
        EmployeeRequest request = EmployeeRequest.newBuilder().setId(1).build();

        // Mock the behavior of the databaseConnector to return null, simulating employee not found
        when(databaseConnector.getEmployee(request.getId())).thenReturn(null);

        // Invoke the getEmployee method
        employeeService.getEmployee(request, responseObserverEmployee);

        // Capture the response and verify it
        ArgumentCaptor<Throwable> errorCaptor = ArgumentCaptor.forClass(Throwable.class);
        verify(responseObserverEmployee).onError(errorCaptor.capture());

        // Assert that the captured error is a StatusRuntimeException with NOT_FOUND status
        Throwable error = errorCaptor.getValue();
        assertTrue(error instanceof StatusRuntimeException);
        assertEquals(Status.NOT_FOUND, ((StatusRuntimeException) error).getStatus());

        // Verify that onCompleted was not called
        verify(responseObserverEmployee, never()).onCompleted();
    }
}