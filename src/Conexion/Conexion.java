package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection connection = null;

    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/ejenplo";

    private final String USER = "postgres";
    private final String PASS = "postgres";

    public void conectar() throws Exception {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cerrarConexion() throws SQLException {
        if (connection != null)
            if (!connection.isClosed())
                connection.close();
    }

}
