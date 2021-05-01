import java.io.ByteArrayInputStream;
import java.util.Date;

public class dijaki
{
    int id_d;
    String ime;
    String priimek;
    String email;
    String geslo;
    String telefon;
    Byte slika;
    int stars_id;
    int kraj_id;
    int razred_id;

    public dijaki(int _id_d, String _ime, String _priimek, String _email, String _geslo, String _telefon,
                  int _stars_id, int _razred_id, Byte _slika, int _kraj_id)
    {
        id_d=_id_d;
        ime=_ime;
        priimek=_priimek;
        email=_email;
        geslo=_geslo;
        telefon=_telefon;
        slika=_slika;
        stars_id=_stars_id;
        kraj_id=_kraj_id;
        razred_id=_razred_id;
    }

    public dijaki(int _id_d, String _ime, String _priimek, String _email, String _geslo, String _telefon,
                  int _stars_id, int _razred_id, int _kraj_id)
    {
        id_d=_id_d;
        ime=_ime;
        priimek=_priimek;
        email=_email;
        geslo=_geslo;
        telefon=_telefon;
        stars_id=_stars_id;
        kraj_id=_kraj_id;
        razred_id=_razred_id;
    }

    public String dijakiString()
    {
        String list;
        list=(id_d+" "+ime+" "+priimek+" "+email+" "+geslo+" "+telefon+" "+slika+" "+kraj_id+" "
                +razred_id+" "+stars_id);
        return list;
    }
}
