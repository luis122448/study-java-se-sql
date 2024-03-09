package luis122448.repository;

import luis122448.model.EmployeeModel;
import luis122448.util.DataBaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository<EmployeeModel,Integer> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    @Override
    public List<EmployeeModel> findAll() throws SQLException {
        List<EmployeeModel> employees = new ArrayList<>();
        try(Statement statement = getConnection().createStatement();){
            statement.executeQuery("SELECT * FROM employees");
            while(statement.getResultSet().next()){
                employees.add(createEmployee(statement.getResultSet()));
            }
        }
        return employees;
    }

    @Override
    public EmployeeModel findById(Integer integer) throws SQLException {
        EmployeeModel employee = null;
        try(PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?");){
            statement.setInt(1, integer);
            statement.executeQuery();
            if(statement.getResultSet().next()){
                employee = createEmployee(statement.getResultSet());
            }
        }
        return employee;
    }

    @Override
    public void save(EmployeeModel employeeModel) {

    }

    @Override
    public void update(EmployeeModel employeeModel) {

    }

    @Override
    public void delete(Integer integer) {

    }

    public EmployeeModel createEmployee(ResultSet resultSet) throws SQLException{
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(resultSet.getInt("id"));
        employeeModel.setFirstName(resultSet.getString("first_name"));
        employeeModel.setPaSurname(resultSet.getString("pa_surname"));
        employeeModel.setMaSurname(resultSet.getString("ma_surname"));
        employeeModel.setEmail(resultSet.getString("email"));
        employeeModel.setSalary(resultSet.getFloat("salary"));
        return employeeModel;
    }

}
