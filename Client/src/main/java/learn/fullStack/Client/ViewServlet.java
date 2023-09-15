package learn.fullStack.Client;

import io.grpc.ManagedChannel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learn.proto.fullstack.Employee;
import learn.proto.fullstack.EmployeeServiceGrpc;
import learn.proto.fullstack.Empty;
import learn.proto.fullstack.GetAllEmpRes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the ManagedChannel from the ChannelProvider
            ManagedChannel channel = ChannelProvider.getChannel();
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<a href='index.html'>Add New Employee</a>");
            out.println("<h1>Employees List</h1>");
            // Create a gRPC blocking stub
            EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);

            // Make the gRPC call to fetch all employees
            Empty requestMessage = Empty.newBuilder().build();
            GetAllEmpRes responseMessage = blockingStub.getAllEmployees(requestMessage);

            // Extract the list of employees from the response
            List<Employee> employees = responseMessage.getEmployeesList();
//
//
            out.print("<table border='1' width='100%'");
            out.print("<tr>" +
                    "<th>FirstName</th>" +
                    "<th>LastName</th>" +
                    "<th>Email</th>" +
                    "<th>Edit</th>"+
                    "<th>Delete</th></tr>");
            for(Employee e:employees){
                out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getEmailId()+"</td><td>"+
                        "<a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
            }
            out.print("</table>");

            out.close();

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
