package LOBs;

/**
 * Created by bimal on 4/7/16.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadBlobDemo {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        InputStream input = null;
        FileOutputStream output = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bimal", "root", "bimal123");

            // 2. Execute statement
            myStmt = myConn.createStatement();
            String sql = "select resume from employees where email='bimal.gaire@deerwalk.edu.np'";
            myRs = myStmt.executeQuery(sql);

            // 3. Set up a handle to the file
            File theFile = new File("resume_from_db.pdf");
            output = new FileOutputStream(theFile);

            if (myRs.next()) {

                input = myRs.getBinaryStream("resume");
                System.out.println("Reading resume from database...");
                System.out.println(sql);

                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                System.out.println("\nSaved to file: " + theFile.getAbsolutePath());

                System.out.println("\nCompleted successfully!");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            if (output != null) {
                output.close();
            }

            close(myConn, myStmt);
        }
    }

    private static void close(Connection myConn, Statement myStmt)
            throws SQLException {

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }
}