import java.io.ByteArrayInputStream;
import java.util.Date;

public class razredi
{
    int id_r;
    String naziv;
    String leto_razreda;

    public  razredi(int _id_r, String _naziv, String _leto_razreda)
    {
        id_r=_id_r;
        naziv=_naziv;
        leto_razreda=_leto_razreda;
    }

    public String razrediString()
    {
        String list;
        list=(id_r+" "+naziv+" "+leto_razreda);
        return list;
    }
}
