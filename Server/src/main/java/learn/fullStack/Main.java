package learn.fullStack;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Injector injector = Guice.createInjector(new MyApplicationModule());
        EmployeeService employeeService = injector.getInstance(EmployeeService.class);
        // Choose a port for your gRPC server

        // Create the gRPC server
        Server server = ServerBuilder.forPort(9090)
                .addService(employeeService)
                .build();

        // Start the server
        server.start();

        System.out.println("gRPC server started on port " + server.getPort()  );

        // Block until the server is terminated
        server.awaitTermination();
    }
}