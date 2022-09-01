package com.claseNueveMapper.app.constants;

public class Constants {

    /**
     * SQL queries person entity constant.
     */
    public static final String SQL_SELECT_PERSON = "SELECT id_person, name, last_name, age, address FROM personas";
    public static final String SQL_INSERT_PERSON = "INSERT INTO personas(name, last_name, age, address) VALUES(?, ?, ?, ?)";
    public static final String SQL_UPDATE_PERSON = "UPDATE personas SET name = ?, last_name = ?, age = ?, address = ? WHERE id_person = ?";
    public static final String SQL_DELETE_PERSON = "DELETE FROM personas WHERE id_person = ?";

    /**
     * Connection variables to DB.
     */
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_ayi_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root57284";

}
