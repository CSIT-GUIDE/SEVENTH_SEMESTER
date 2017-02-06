package generatedkeys;

import java.sql.*;

/**
 * Created by bimal on 4/7/16.
 */
public class GeneratedKeyDemo {

    public static void main(String[] args) throws Exception {

        String Query = "insert into demo (name,phone,address)values('bimal gaire',7676,'new')";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/bimal", "root", "iam@Dwit!23AD1");

        PreparedStatement ps = con.prepareStatement(Query, new String[]{"id"});

        if (ps.executeUpdate() > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                System.out.println(id);
            }
        }
    }
}