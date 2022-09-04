package com.claseNueveMapper.app.constants;

public class Constants {

    /**
     * SQL queries entity constant.
     */
    public static final String SQL_SELECT_PERSON = "SELECT id, name, last_name, age, address FROM personas";
    public static final String SQL_SELECT_PERSON_BY_ID = "SELECT id, name, last_name, age, address FROM personas WHERE id = ?";
    public static final String SQL_INSERT_PERSON = "INSERT INTO personas(name, last_name, age, address) VALUES(?, ?, ?, ?)";
    public static final String SQL_UPDATE_PERSON = "UPDATE personas SET name = ?, last_name = ?, age = ?, address = ? WHERE id = ?";
    public static final String SQL_DELETE_PERSON = "DELETE FROM personas WHERE id = ?";

    public static final String SQL_SELECT_EMPLOYEE = "SELECT id, alta_contrato, salario, persona_FK FROM empleados";
    public static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT id, alta_contrato, salario, persona_FK FROM empleados WHERE id = ?";
    public static final String SQL_INSERT_EMPLOYEE = "INSERT INTO empleados(alta_contrato, salario, persona_FK) VALUES(?, ?, ?)";
    public static final String SQL_UPDATE_EMPLOYEE = "UPDATE empleados SET salario = ? WHERE id = ?";
    public static final String SQL_DELETE_EMPLOYEE = "DELETE FROM empleados WHERE id = ?";

    /**
     * Connection variables to DB.
     */
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_ayi_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root57284";

}
