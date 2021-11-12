package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

    private Connection connect() {
        String url = "jdbc:sqlite:prueba.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
    
    public void selectAll() {
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
// Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t"
                        + rs.getString("Name") + "\t"
                        + rs.getString("Apellidos") + "\t"
                        + rs.getString("Departamentos") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
