import java.io.ByteArrayInputStream;
import java.util.Date;

public class starsi
{
    int id_s;
    String ime;
    String priimek;
    String email;
    String geslo;
    String telefon;
    int kraj_id;

    public starsi(String _ime, String _priimek, String _email, String _geslo, String _telefon, int _kraj_id)
    {
        ime=_ime;
        priimek=_priimek;
        email=_email;
        geslo=_geslo;
        telefon=_telefon;
        kraj_id = _kraj_id;
    }

    public starsi()
    {

    }

    public String starsiString()
    {
        String list;
        list=(id_s+" "+ime+" "+priimek+" "+email+" "+geslo+" "+telefon+" "+kraj_id);
        return list;
    }
}
