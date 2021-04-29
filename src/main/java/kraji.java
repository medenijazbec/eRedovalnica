import java.io.ByteArrayInputStream;
import java.util.Date;

public class kraji
{
    int id_k;
    String naslov;
    String posta;

    public  kraji(int _id_k, String _naslov, String _posta)
    {
        id_k=_id_k;
        naslov=_naslov;
        posta=_posta;
    }

    public String krajiString()
    {
        String list;
        list=(id_k+" "+naslov+" "+posta);
        return list;
    }
}
