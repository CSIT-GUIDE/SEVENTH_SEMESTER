package storedprocedure;

/**
 * Created by bimal on 4/7/16.
 */
import java.sql.*;

public class StoredProcedureDemo {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        CallableStatement myStmt = null;

        try {
            // Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bimal", "root", "bimal123");

            String theDepartment = "Data Analytics";
            int theIncreaseAmount = 10000;

            // Show salaries BEFORE
            System.out.println("Salaries BEFORE\n");
            showSalaries(myConn, theDepartment);

            // Prepare the stored procedure call
            myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");

            // Set the parameters
            myStmt.setString(1, theDepartment);
            myStmt.setDouble(2, theIncreaseAmount);

            // Call stored procedure
            System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department('" + theDepartment + "', " + theIncreaseAmount + ")");
            myStmt.execute();
            System.out.println("Finished calling stored procedure");

            // Show salaries AFTER
            System.out.println("\n\nSalaries AFTER\n");
            showSalaries(myConn, theDepartment);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myConn, myStmt, null);
        }
    }

    private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // Prepare statement
            myStmt = myConn
                    .prepareStatement("select * from info where department=?");

            myStmt.setString(1, theDepartment);

            // Execute SQL query
            myRs = myStmt.executeQuery();

            // Process result set
            while (myRs.next()) {
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                int salary = myRs.getInt("salary");
                String department = myRs.getString("department");

                System.out.printf("%d, %s, %d, %s\n", id, name, salary, department);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myStmt, myRs);
        }

    }

    private static void close(Connection myConn, Statement myStmt,
                              ResultSet myRs) throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private static void close(Statement myStmt, ResultSet myRs)
            throws SQLException {

        close(null, myStmt, myRs);
    }
}
