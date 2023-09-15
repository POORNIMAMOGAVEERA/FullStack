package learn.fullStack.Client;

import io.grpc.ManagedChannel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learn.proto.fullstack.EmployeeServiceGrpc;
import learn.proto.fullstack.UpdateEmployeeRequest;
import learn.proto.fullstack.UpdateEmployeeResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String sid = request.getParameter("id");
            long id = Long.parseLong(sid);
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("emailId");

            ManagedChannel channel = ChannelProvider.getChannel();
            // Create a gRPC blocking stub
            EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
            UpdateEmployeeRequest req = UpdateEmployeeRequest.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmailId(email).build();
            UpdateEmployeeResponse res = blockingStub.updateEmployee(req);

            if (req.getFirstName().equals(res.getEmployee().getFirstName()) && req.getLastName().equals(res.getEmployee().getLastName()) && req.getEmailId().equals(res.getEmployee().getEmailId())) {
                response.sendRedirect("ViewServlet");
            } else {
                out.println("Sorry! unable to update record");
            }

            out.close();
        } catch (Exception e) {
            // Handle exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

}
