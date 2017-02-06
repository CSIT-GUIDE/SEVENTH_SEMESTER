package preparedstatment;

/**
 * Created by bimal on 4/7/16.
 */


import java.sql.*;

public class PreparedStatementDemo1 {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bimal", "root" , "bimal123");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("select * from info where " +
                    "salary > ? and department=?");

            // 3. Set the parameters
            myStmt.setDouble(1, 60000);
            myStmt.setString(2, "Data Analytics");

            // 4. Execute SQL query
            myRs = myStmt.executeQuery();

            // 5. Display the result set
            display(myRs);

            //
            // Reuse the prepared statement:  salary > 25000,  department = HR
            //

           System.out.println("\n\nReuse the prepared statement:  salary > 25000,  department = HR");

            // 6. Set the parameters
           myStmt.setDouble(1, 25000);
            myStmt.setString(2, "HR");

            // 7. Execute SQL query
            myRs = myStmt.executeQuery();

            // 8. Display the result set
           display(myRs);


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
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
    }

    private static void display(ResultSet myRs) throws SQLException {
        while (myRs.next()) {
            int id = myRs.getInt("id");
            String name = myRs.getString("name");
            int salary = myRs.getInt("salary");
            String department = myRs.getString("department");

            System.out.printf("%d, %s, %d, %s\n", id, name, salary, department);
        }
    }
}
