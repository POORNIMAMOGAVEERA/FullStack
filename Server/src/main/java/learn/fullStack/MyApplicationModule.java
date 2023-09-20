package learn.fullStack;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class MyApplicationModule extends AbstractModule{
    @Override
    protected void configure() {
        // Bind the DatabaseConnector to a singleton instance
        bind(DatabaseConnector.class).toInstance(createDatabaseConnector());
    }
    @Singleton
    private DatabaseConnector createDatabaseConnector() {
        // Configure and create your DatabaseConnector instance here
        String jdbcUrl = "jdbc:mysql://localhost:3306/GRPCFullstack";
        String username = "root";
        String password = (password);

        return new DatabaseConnector(jdbcUrl, username, password);
    }
}
