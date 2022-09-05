package com.claseNueveMapper.app.service.impl;

import com.claseNueveMapper.app.configuration.ConnectionDB;
import com.claseNueveMapper.app.constants.Constants;
import com.claseNueveMapper.app.dtos.request.EmployeeDTO;
import com.claseNueveMapper.app.dtos.response.EmployeeResponseDTO;
import com.claseNueveMapper.app.entity.Employee;
import com.claseNueveMapper.app.mapper.EmployeeMapperImpl;
import com.claseNueveMapper.app.service.IEmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static com.claseNueveMapper.app.utils.CheckDataBase.isRegistrationExist;

public class EmployeeServiceImpl implements IEmployeeService {

    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
    private ConnectionDB connectionDB = new ConnectionDB();

    //private EmployeeMapperImpl employeeMapperImpl = new EmployeeMapperImpl();

    @Override
    public void insertEmployee(Employee employee) {

        //Para determinar si la persona relacionada existe en los registros
        isRegistrationExist("personas", employee.getIdPersonEmployee());

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_INSERT_EMPLOYEE);

            long time = employee.getStartContract().getTime();
            stmt.setDate(1, new Date(time));
            stmt.setDouble(2, employee.getSalary());
            stmt.setInt(3,employee.getIdPersonEmployee());

            stmt.executeUpdate();

            System.out.println("Se ingresó al empleado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeDTO employeeDTO, Integer id) {

        isRegistrationExist("empleados", id);

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_UPDATE_EMPLOYEE);

            //Solo permito modificar el salario del empleado;
            stmt.setDouble(1, employeeDTO.getSalary());
            stmt.setInt(2, id);

            Integer resultUpdate = stmt.executeUpdate();

            System.out.println(resultUpdate);

            //Parcial - A mejorar - Para que no devuelva error
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            return employeeResponseDTO;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void deleteEmployee(Integer id) {

        isRegistrationExist("empleados", id);

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_EMPLOYEE);

            stmt.setInt(1,id);

            Integer resultDelete = stmt.executeUpdate();

            if(resultDelete==0){
                System.out.println("No se encontró registro con id: " + id);
            } else {
                System.out.println("Borrando datos de empleado con id " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();
        Employee employee;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_EMPLOYEE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmployee = rs.getInt("id");
                Date startContract = rs.getDate("alta_contrato");
                Double salary = rs.getDouble("salario");
                Integer idPersonEmployee = rs.getInt("persona_FK");

                employee = new Employee(idEmployee, startContract, salary,idPersonEmployee);

                employees.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connectionDB.close(rs);
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return employees;
    }

    public Employee getOneEmployee(Integer id){

        isRegistrationExist("empleados", id);

        Employee employee = new Employee();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_EMPLOYEE_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                employee.setStartContract(rs.getDate("alta_contrato"));
                employee.setSalary(rs.getDouble("salario"));
                employee.setIdPersonEmployee(rs.getInt("persona_FK"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connectionDB.close(rs);
                connectionDB.close(stmt);
                connectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return employee;

    }

}
