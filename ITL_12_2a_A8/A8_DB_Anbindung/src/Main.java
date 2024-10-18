import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Database connection URL
        String dbUrl = "jdbc:mariadb://127.0.0.1:3306/itl12_db";
        String username = "root";
        String userPassword = "";
        Scanner inputScanner = new Scanner(System.in);



        // Attempt to connect to the database
        try (Connection connection = Connector.getConnection(dbUrl, username, userPassword)) {
            if (connection != null) {
                System.out.println("Verbindung zur MariaDB erfolgreich hergestellt!");
                Tables.selectAllFromPersonTable(connection);
            } else {
                System.out.println("Verbindung fehlgeschlagen.");
            }
        } catch (Exception ex) {
            System.err.println("Fehler: " + ex.getMessage());
        }
    }
}