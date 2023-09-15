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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");
        String sid=request.getParameter("id");
        long id=Long.parseLong(sid);

        ManagedChannel channel = ChannelProvider.getChannel();
        // Create a gRPC blocking stub
        EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);

        // Make the gRPC call to fetch all employees
        EmployeeRequest requestMessage = EmployeeRequest.newBuilder().setId(id).build();
        Employee responseMessage = blockingStub.getEmployee(requestMessage);


        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+responseMessage.getId()+"'/></td></tr>");
        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstName' value='"+responseMessage.getFirstName()+"'/></td></tr>");
        out.print("<tr><td>LastName:</td><td><input type='text' name='lastName' value='"+responseMessage.getLastName()+"'/> </td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='emailId' value='"+responseMessage.getEmailId()+"'/></td></tr>");
        out.print("<tr><td col-span='2'><input type='submit' value='Edit&Save'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
