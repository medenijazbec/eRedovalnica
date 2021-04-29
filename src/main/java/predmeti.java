import java.io.ByteArrayInputStream;
import java.util.Date;

public class predmeti
{
    int id_p;
    String naziv;
    String opis;

    public predmeti(int _id_p, String _naziv)
    {
        id_p=_id_p;
        naziv=_naziv;
    }

    public predmeti(int _id_k, String _naslov, String _posta)
    {
        id_p=_id_k;
        naziv=_naslov;
        opis=_posta;
    }

    public String predmetiString()
    {
        String list;
        list=(id_p+" "+naziv+" "+opis);
        return list;
    }
}
