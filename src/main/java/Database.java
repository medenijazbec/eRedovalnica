import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database
{
    public static Connection connect()
    {
        String url = "jdbc:postgresql://ec2-52-209-134-160.eu-west-1.compute.amazonaws.com:5432/df1c3um7mlhs19";
        String user = "tgjeirvzipmyjp";
        String password = "aa125fa79f38a582e7956cb0a53b5772d346e65569e683341bf3580d6c66b8df";
        Connection con = null;

        try
        {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    public static String izpisKraja()
    {
        String Kraj, Posta, vrniKraj="";
        String cmd = "SELECT * FROM kraji;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

            // loop through the records
            while (set.next())
            {
                Kraj = set.getString("naslov");
                Posta = set.getString("posta");
                vrniKraj = vrniKraj + " " + Kraj + " " + Posta + ",";
            }
        }

        catch (SQLException e)
        {
            //Messages.databaseReadingError(database, e.getMessage());
            System.out.println(e.getMessage());
        }

        return vrniKraj;
    }

    public static void posodobiKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "UPDATE kraji SET naslov = " + naslovKraja + ", posta = " + postaKraj;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            //Messages.databaseReadingError(database, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void izbrisKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "DELETE FROM kraji WHERE naslov = " + naslovKraja + ", posta = " + postaKraj;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            //Messages.databaseReadingError(database, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public static void vnosKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "INSERT INTO kraji (naslov, posta) VALUES (" + naslovKraja + "," + postaKraj + ");";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            //Messages.databaseReadingError(database, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
