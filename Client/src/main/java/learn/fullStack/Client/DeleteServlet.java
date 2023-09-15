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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String sid = req.getParameter("id");
        long id  = Long.parseLong(sid);
        ManagedChannel channel = ChannelProvider.getChannel();
        PrintWriter out = resp.getWriter();
        // Create a gRPC blocking stub
        EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);

        // Make the gRPC call to fetch all employees
        EmployeeRequest requestMessage = EmployeeRequest.newBuilder().setId(id).build();
        EmployeeResponse responseMessage = blockingStub.deleteEmployee(requestMessage);
        if(responseMessage.getStatus().contentEquals("Employee deleted successfully")){
            resp.sendRedirect("ViewServlet");
        }else{
            out.println("Couldn't delete the Employee");
        }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
