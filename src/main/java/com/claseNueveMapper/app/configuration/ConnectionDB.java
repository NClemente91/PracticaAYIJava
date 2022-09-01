package com.claseNueveMapper.app.configuration;

import java.sql.*;

import static com.claseNueveMapper.app.constants.Constants.*;

public class ConnectionDB {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public void close(Connection conn) throws SQLException{
        conn.close();
    }

}
