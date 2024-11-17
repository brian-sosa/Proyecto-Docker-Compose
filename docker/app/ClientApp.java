import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientApp {
    public static void main(String[] args) {
     
        String url = "jdbc:postgresql://database:5432/testdb";
        String usuario = "postgres";
        String contrasena = "password";

        try {
            
            Class.forName("org.postgresql.Driver");

            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos.");

            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}

