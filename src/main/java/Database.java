import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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
        String Kraj, vrniKraj="";
        String cmd = "SELECT * FROM kraji;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

            while (set.next())
            {
                Kraj = set.getString("naslov");
                vrniKraj = vrniKraj + Kraj + ",";
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return vrniKraj;
    }

    public static void posodobiKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "UPDATE kraji SET naslov = '" + naslovKraja + "', posta = '" + postaKraj + "';";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void izbrisKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "DELETE FROM kraji WHERE naslov = '" + naslovKraja + "', posta = '" + postaKraj + "';";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void vnosKraj(String naslovKraja, String postaKraj)
    {
        String cmd = "INSERT INTO kraji (naslov, posta) VALUES ('" + naslovKraja + "','" + postaKraj + "');";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static int Preveri_ucitelja_registracija()
    {
        String cmd = "SELECT * FROM Preveri_ucitelja_register()";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

            // loop through the records
            while (set.next())
            {

            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return 1;
    }

    public static int Vrni_id_ucitelj_razred(String nazivv)
    {
        String cmd = "SELECT id_r FROM razredi WHERE naziv = '" + nazivv + "';";
        int id = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

            // loop through the records
            while (set.next())
            {
                id = set.getInt("id_r");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static int Vrni_id_ucitelj_kraj(String naslovv)
    {
        String cmd = "SELECT id_k FROM kraji WHERE naslov = '" + naslovv + "';";
        int idd = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                idd = set.getInt("id_k");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return idd;
    }

    public static String izpisRazredov()
    {
        String Razred, vrniR="";
        String cmd = "SELECT * FROM razredi;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

            // loop through the records
            while (set.next())
            {
                Razred = set.getString("naziv");
                vrniR = vrniR + Razred + ",";
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return vrniR;
    }

    public static int geslo_Ucitelji(String naslovv, String gesloo)
    {
        String cmd = "SELECT Posodobi_geslo_ucitelj('" + naslovv + "','" + gesloo + "');";
        int id_u = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                id_u = set.getInt(1);
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return id_u;
    }

    public static int geslo_starsi(String naslovv, String gesloo)
    {
        String cmd = "SELECT Posodobi_geslo_starsekk('" + naslovv + "','" + gesloo + "');";
        int id_s = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                id_s = set.getInt(1);
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return id_s;
    }

    public static int geslo_dijaki(String naslovv, String gesloo)
    {
        String cmd = "SELECT Posodobi_geslo_dijak('" + naslovv + "','" + gesloo + "');";
        int id_d = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                id_d = set.getInt(1);
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return id_d;
    }

    public static int Prijava_ucitelji(String email, String password)
    {
        String cmd = "SELECT id_u FROM ucitelji WHERE email = '" + email + "' AND geslo = '" + password + "';";
        int id = 0;
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                id = set.getInt("id_u");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static int Prijava_dijaki(String email, String password)
    {
        String cmd = "SELECT id_d FROM dijaki WHERE email = '" + email + "' AND geslo = '" + password + "';";
        int id = 0;
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                id = set.getInt("id_d");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static int Prijava_starsi(String email, String password)
    {
        String cmd = "SELECT id_s FROM starsi WHERE email = '" + email + "' AND geslo = '" + password + "';";
        int id = 0;
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                id = set.getInt("id_s");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static int Ucitelji_registracija(String ime, String priimek, String email, String password,
                                            String telefon, int razred, int kraj)
    {
        String cmd = "SELECT Preveri_ucitelja_registracijaaaa('" + ime + "','" + priimek + "','" + email + "','" + password + "','"
                + telefon + "','" + razred + "','" + kraj + "');";
        int id = -1;
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                id = set.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static int Starsi_registracija(String ime, String priimek, String email, String password,
                                          String telefon, int kraj)
    {
        String cmd = "SELECT Preveri_stars_registracijaa('" + ime + "','" + priimek + "','" + email + "','" + password + "','"
                + telefon + "','" + kraj + "');";
        int id = -1;
        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                id = set.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    public static String Ucitelj_seja(String email)
    {
        int id = 0;
        String cmd = "SELECT * FROM ucitelji WHERE email = '" + email + "';";
        String ime="", priimek="", skupaj="";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                ime = set.getString(2);
                priimek = set.getString(3);
            }

            skupaj = ime + " " + priimek;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return skupaj;
    }

    public static String Starsi_seja(String email)
    {
        int id = 0;
        String cmd = "SELECT * FROM starsi WHERE email = '" + email + "';";
        String ime="", priimek="", skupaj="";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                ime = set.getString(2);
                priimek = set.getString(3);
            }

            skupaj = ime + " " + priimek;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return skupaj;
    }

    public static String Izpis_dijaki()
    {
        String Dijak_ime="", Dijak_priimek="", vrniDijak="";
        String cmd = "SELECT * FROM dijaki;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                Dijak_ime = set.getString("ime");
                Dijak_priimek = set.getString("priimek");
                vrniDijak =  vrniDijak + Dijak_ime + " " + Dijak_priimek + ",";
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return vrniDijak;
    }

    public static String izpisPredmetov()
    {
        String Razred, vrniR="";
        String cmd = "SELECT * FROM predmeti;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            // loop through the records
            while (set.next())
            {
                Razred = set.getString("naziv");
                vrniR = vrniR + Razred + ",";
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return vrniR;
    }

    public static String izpisDijakov()
    {
        String Razred, vrniR="", ime="";
        String cmd = "SELECT * FROM dijaki;";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            // loop through the records
            while (set.next())
            {
                ime = set.getString("ime");
                Razred = set.getString("priimek");
                vrniR = vrniR + ime + " " + Razred + ",";
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return vrniR;
    }

    public static void Vnos_ocene(String naziv, String opis)
    {
        int id = 0;
        String cmd = "SELECT * FROM ucitelji;";
        String ime="", priimek="", skupaj="";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd)) {

            while (set.next())
            {
                ime = set.getString(2);
                priimek = set.getString(3);
            }

            skupaj = ime + " " + priimek;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void vnosOcena(String naziv, String opis, String tip_ocene, int ocena, int ucitelj_id, int predmet_id, int dijak_id)
    {
        String cmd = "INSERT INTO ocena (naziv, opis, datum_oddaje, tip_ocene, ocena, ucitelj_id, predmet_id, dijak_id) VALUES ('" + naziv + "','" + opis + "','" + LocalDateTime.now() + "','" + tip_ocene + "','" + ocena + "','" + ucitelj_id + "','" + predmet_id + "','" + dijak_id + "');";

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {

        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static int Vrni_id_ucitelj_ocena(String ime, String priimek)
    {
        String cmd = "SELECT id_u FROM ucitelji WHERE ime = '" + ime + "' AND priimek = '" + priimek + "';";
        int idd = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                idd = set.getInt("id_u");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return idd;
    }

    public static int Vrni_id_dijak_ocena(String ime, String priimek)
    {
        String cmd = "SELECT id_d FROM dijaki WHERE ime = '" + ime + "' AND priimek = '" + priimek + "';";
        int idd = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                idd = set.getInt("id_d");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return idd;
    }

    public static int Vrni_id_predmet_ocena(String naziv)
    {
        String cmd = "SELECT id_p FROM predmeti WHERE naziv = '" + naziv + "';";
        int idd = -1;

        try (Connection con = connect();
             Statement st = con.createStatement();
             ResultSet set = st.executeQuery(cmd))
        {
            while (set.next())
            {
                idd = set.getInt("id_p");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return idd;
    }
}
