package org.example.companyemployeeee.manager;

import org.example.companyemployeeee.db.DBConnectionProvider;
import org.example.companyemployeeee.model.Company;
import org.example.companyemployeeee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private CompanyManager companyManager = new CompanyManager();

    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                employees.add(Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .company(companyManager.getCompanyById(resultSet.getInt("company_id")))
                        .build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }


    public void add(Employee employee) {
        String sql = "INSERT INTO employee(name,surname,email,company_id) VALUES(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setInt(4, employee.getCompany().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                employee.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Employee> getByCompanyId(int companyId) {
        String sql = "SELECT * FROM employee WHERE company_id = " + companyId;
        List<Employee> employees = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                employees.add(Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .company(companyManager.getCompanyById(resultSet.getInt("company_id")))
                        .build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
