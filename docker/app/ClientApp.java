import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientApp {
    public static void main(String[] args) {
        // URL de conexión a PostgreSQL
        String url = "jdbc:postgresql://database:5432/postgres";
        String usuario = "postgres";
        String contrasena = "password";

        // Conexión a la base de datos
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Establecer conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos.");

            // Crear una consulta
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ejemplo;");

            // Mostrar resultados
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }

            // Cerrar conexión
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}

