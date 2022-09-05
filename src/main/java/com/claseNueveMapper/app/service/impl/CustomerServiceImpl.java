package com.claseNueveMapper.app.service.impl;

import com.claseNueveMapper.app.configuration.ConnectionDB;
import com.claseNueveMapper.app.constants.Constants;
import com.claseNueveMapper.app.dtos.request.CustomerDTO;
import com.claseNueveMapper.app.dtos.response.CustomerResponseDTO;
import com.claseNueveMapper.app.entity.Customer;
import com.claseNueveMapper.app.mapper.CustomerMapperImpl;
import com.claseNueveMapper.app.service.ICustomerService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.claseNueveMapper.app.utils.CheckDataBase.isRegistrationExist;

public class CustomerServiceImpl implements ICustomerService {

    //En este archivo haríamos las peticiones a la base de datos. Desde las implementaciones a través de la interfase.
    private ConnectionDB connectionDB = new ConnectionDB();

    //private CustomerMapperImpl customerMapperImpl = new CustomerMapperImpl();

    @Override
    public void insertCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //Para determinar si la persona relacionada existe en los registros
            isRegistrationExist("personas", customer.getIdPersonCustomer());

            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_INSERT_CUSTOMER);

            stmt.setBoolean(1, customer.isVip());
            stmt.setInt(2,customer.getIdPersonCustomer());

            stmt.executeUpdate();

            System.out.println("Se ingresó al cliente correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (stmt != null || conn != null) {
                    connectionDB.close(stmt);
                    connectionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerDTO customerDTO, Integer id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            isRegistrationExist("clientes", id);

            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_UPDATE_CUSTOMER);

            //Solo permito modificar el parámetro vip del empleado;
            stmt.setBoolean(1, customerDTO.getVip());
            stmt.setInt(2, id);

            Integer resultUpdate = stmt.executeUpdate();

            System.out.println(resultUpdate);

            //Parcial - A mejorar - Para que no devuelva error
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            return customerResponseDTO;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (stmt != null || conn != null) {
                    connectionDB.close(stmt);
                    connectionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            isRegistrationExist("clientes", id);

            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_DELETE_CUSTOMER);

            stmt.setInt(1,id);

            Integer resultDelete = stmt.executeUpdate();

            if(resultDelete==0){
                System.out.println("No se encontró registro con id: " + id);
            } else {
                System.out.println("Borrando datos de cliente con id " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (stmt != null || conn != null) {
                    connectionDB.close(stmt);
                    connectionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_CUSTOMER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCustomer = rs.getInt("id");
                Boolean vip = rs.getBoolean("vip");
                Integer idPersonCustomer = rs.getInt("persona_FK");

                customer = new Customer(idCustomer, vip, idPersonCustomer);

                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (rs != null || stmt != null || conn != null) {
                    connectionDB.close(rs);
                    connectionDB.close(stmt);
                    connectionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return customers;
    }

    public Customer getOneCustomer(Integer id){
        Customer customer = new Customer();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(Constants.SQL_SELECT_CUSTOMER_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                customer.setVip(rs.getBoolean("vip"));
                customer.setIdPersonCustomer(rs.getInt("persona_FK"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (rs != null || stmt != null || conn != null) {
                    connectionDB.close(rs);
                    connectionDB.close(stmt);
                    connectionDB.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return customer;

    }
}
