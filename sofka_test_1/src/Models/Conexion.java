package Models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/sofka_juego_2?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    
    protected PreparedStatement ps;
    protected ResultSet rs;
    
    public Connection getCOnnection() {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection(URL, USER, PASS);
            
        } catch(Exception ex) {
            System.out.println("Error miesntras se establecia una conexion con el servidor");
        }
        return cnx;
    }
}
