package luis122448;

import luis122448.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try(Connection connection = DataBaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");){
            while(resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}