import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tables {
    public static void selectAllFromPersonTable(Connection connection) {
        String query = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Enhanced table header
            System.out.println("+-------+------------+-----------+---------+--------+");
            System.out.println("| EMPNO | ENAME      | JOB       | SALARY  | DEPTNO |");
            System.out.println("+-------+------------+-----------+---------+--------+");

            // Enhanced result rows
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String ename = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                double salary = resultSet.getDouble("SAL");
                int deptNo = resultSet.getInt("DEPTNO");

                System.out.printf("| %5d | %-10s | %-9s | %7.2f | %6d |%n", empNo, ename, job, salary, deptNo);
            }

            // Closing table border
            System.out.println("+-------+------------+-----------+---------+--------+");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}