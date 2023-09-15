package learn.db;

import learn.proto.fullstack.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    public static List<Employee> getEmployees(){
        return new ArrayList<Employee>(){
            {
                add(Employee.newBuilder().setId(1).setFirstName("Poornima").setLastName("Mogaveera").setEmailId("Poornima@gmail.com").build());
                add(Employee.newBuilder().setId(2).setFirstName("Spoorthi").setLastName("Mendon").setEmailId("Spoorthi@gmail.com").build());
                add(Employee.newBuilder().setId(3).setFirstName("Ashritha").setLastName("Mendon").setEmailId("Ashritha@gmail.com").build());
                add(Employee.newBuilder().setId(4).setFirstName("Abhi").setLastName("Mogaveera").setEmailId("Abhi@gmail.com").build());
                add(Employee.newBuilder().setId(5).setFirstName("Sanketha").setLastName("Mogaveera").setEmailId("Sanketha@gmail.com").build());
            }
        };
    }
}
