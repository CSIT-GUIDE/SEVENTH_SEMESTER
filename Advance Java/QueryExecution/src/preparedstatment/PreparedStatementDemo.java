package preparedstatment;

import java.sql.*;

/**
 * Created by bimal on 4/6/16.
 */
public class PreparedStatementDemo {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://192.168.1.55:3306/bimal", "root", "bimal123");
        PreparedStatement ps = con.prepareStatement
                ("insert into emp values(?,?,?)");
        ps.setInt(1,23);
        ps.setString(2,"Bimal");
        ps.setString(3, "Intern");


        ps.executeUpdate();
        Statement stmt = con.createStatement();
        String query = "select * from emp";
        ResultSet rs =  stmt.executeQuery(query);
        System.out.println("Id Name    Job");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String job = rs.getString("job");
            System.out.println(id + "  " + name+"   "+job);
        }
    }
}
