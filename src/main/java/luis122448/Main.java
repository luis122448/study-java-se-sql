package luis122448;

import luis122448.model.EmployeeModel;
import luis122448.repository.EmployeeRepository;
import luis122448.repository.EmployeeRepositoryImpl;
import luis122448.util.DataBaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
            EmployeeRepository<EmployeeModel,Integer> repository = new EmployeeRepositoryImpl();
            System.out.println("List of employees: "+repository.findAll());
            System.out.println("Employee with id 1: "+repository.findById(1));

//            System.out.println("Inserting a new employee");
//            EmployeeModel employee = new EmployeeModel();
//            employee.setFirstName("Luis Antonio");
//            employee.setPaSurname("Calvo");
//            employee.setMaSurname("Quispe");
//            employee.setEmail("luis122448@gmail.com");
//            employee.setSalary(10000F);
//            repository.save(employee);
//            System.out.println("List of employees: "+repository.findAll());

//            System.out.println("Updating employee with id 6");
//            employee.setId(6);
//            employee.setSalary(15000F);
//            repository.update(employee);
//            System.out.println("Employee with id 6: "+repository.findById(6));

//            System.out.println("Deleting employee with id 6");
//            repository.delete(6);
//            System.out.println("List of employees: "+repository.findAll());
    }
}