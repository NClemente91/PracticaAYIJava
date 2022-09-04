package com.claseNueveMapper.app.utils;

import com.claseNueveMapper.app.configuration.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckDataBase {
    private static ConnectionDB connectionDB = new ConnectionDB();

    public static Boolean isRegistrationExist(String table, Integer id){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sentence = "SELECT id FROM " + table + " WHERE id = ?";

        try {
            conn = connectionDB.getConnection();
            stmt = conn.prepareStatement(sentence);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("El registro en la tabla " + table + " con id " + id + " no existe");
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    }
}
