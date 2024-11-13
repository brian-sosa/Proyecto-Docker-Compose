import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientApp {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM example_table");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Name: " + rs.getString("name") + 
                                   ", Value: " + rs.getInt("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
