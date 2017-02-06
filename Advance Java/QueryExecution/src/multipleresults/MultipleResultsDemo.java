package multipleresults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by bimal on 4/7/16.
 */


public class MultipleResultsDemo
{
    public static void main(String[] args) throws Exception
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bimal", "root", "bimal123");
            String SQL = " SELECT * FROM info \n"
                    + " SELECT top 5 from info \n" ;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while ( rs != null )
            {
                System.out.println( "\n---Result set---\n" );
                while (rs.next())
                {
                    System.out.println(rs.getString(1)
                            + ", " + rs.getString(2));
                }
                if( stmt.getMoreResults() )
                {
                    rs = stmt.getResultSet();
                }
                else
                {
                    rs.close();
                    rs = null;
                }
            }
            stmt.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if( conn != null) conn.close();
    }
}