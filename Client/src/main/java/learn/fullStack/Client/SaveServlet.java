package learn.fullStack.Client;

import io.grpc.ManagedChannel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learn.proto.fullstack.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get the ManagedChannel from the ChannelProvider
            ManagedChannel channel = ChannelProvider.getChannel();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("emailId");
            // Create a gRPC blocking stub
            EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);

            CreateEmployeeRequest createRequest = CreateEmployeeRequest.newBuilder()
                    .setEmployee(Employee.newBuilder()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmailId(email)
                            .build())
                    .build();

            // Make the gRPC call to add the employee
            EmployeeResponse employeeResponse = blockingStub.createEmployee(createRequest);

            if (employeeResponse.getStatus().equals("Employee created successfully")) {
                out.print("<h1>Record saved successfully!</h1>");
                request.getRequestDispatcher("index.html").include(request, response);
            } else {
                out.println("Sorry! unable to save record");
            }

            out.close();
        } catch (Exception e) {
            // Handle exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
