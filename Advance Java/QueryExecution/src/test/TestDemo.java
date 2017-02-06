package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by bimal on 4/6/16.
 */
public class TestDemo {

    private Connection connection = null;
    private String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/adbms";
    private final String user = "root";
    private final String password = "iam@wit!23AD1";
    Statement statement = null;

    public TestDemo() {

        try {
            Class.forName(driver);
            System.out.println("Database connection is completed");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();

    }
}
