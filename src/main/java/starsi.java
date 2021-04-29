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

    public starsi(int _id_s, String _ime, String _priimek, String _email, String _geslo, String _telefon)
    {
        id_s=_id_s;
        ime=_ime;
        priimek=_priimek;
        email=_email;
        geslo=_geslo;
        telefon=_telefon;
    }

    public String starsiString()
    {
        String list;
        list=(id_s+" "+ime+" "+priimek+" "+email+" "+geslo+" "+telefon+" "+kraj_id);
        return list;
    }
}
