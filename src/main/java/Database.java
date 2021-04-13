import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    public static Connection connect() {
        String url = "postgres://tgjeirvzipmyjp:aa125fa79f38a582e7956cb0a53b5772d346e65569e683341bf3580d6c66b8df@ec2-52-209-134-160.eu-west-1.compute.amazonaws.com:5432/df1c3um7mlhs19";
        String user = "tgjeirvzipmyjp";
        String password = "aa125fa79f38a582e7956cb0a53b5772d346e65569e683341bf3580d6c66b8df";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
