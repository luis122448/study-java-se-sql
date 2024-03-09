package luis122448.repository;

import luis122448.model.EmployeeModel;
import luis122448.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository<EmployeeModel,Integer> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getConnection();
    }

    @Override
    public List<EmployeeModel> findAll() throws SQLException {
        List<EmployeeModel> employees = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();){
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
        String sql = "SELECT * FROM employees WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setInt(1, integer);
            statement.executeQuery();
            if(statement.getResultSet().next()){
                employee = createEmployee(statement.getResultSet());
            }
        }
        return employee;
    }

    @Override
    public void save(EmployeeModel employeeModel) throws SQLException {
        String sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary) VALUES (?,?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setString(1, employeeModel.getFirstName());
            statement.setString(2, employeeModel.getPaSurname());
            statement.setString(3, employeeModel.getMaSurname());
            statement.setString(4, employeeModel.getEmail());
            statement.setFloat(5, employeeModel.getSalary());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(EmployeeModel employeeModel) throws SQLException {
        String sql = "UPDATE employees SET first_name = ?, pa_surname = ?, ma_surname = ?, email = ?, salary = ? WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setString(1, employeeModel.getFirstName());
            statement.setString(2, employeeModel.getPaSurname());
            statement.setString(3, employeeModel.getMaSurname());
            statement.setString(4, employeeModel.getEmail());
            statement.setFloat(5, employeeModel.getSalary());
            statement.setInt(6, employeeModel.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer integer) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){
            statement.setInt(1, integer);
            statement.executeUpdate();
        }
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
