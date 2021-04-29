import java.util.Date;

public class ucitelji
{
    int id_u;
    String ime;
    String priimek;
    String email;
    String geslo;
    String telefon;
    int razred_id;
    int kraj_id;

    public ucitelji(String _ime, String _priimek, String _email, String _geslo, String _telefon, int _razred_id, int _kraj_id)
    {
        ime=_ime;
        priimek=_priimek;
        email=_email;
        geslo=_geslo;
        telefon=_telefon;
        razred_id=_razred_id;
        kraj_id=_kraj_id;
    }

    public String uciteljiString()
    {
        String list;
        list=(id_u+" "+ime+" "+priimek+" "+email+" "+geslo+" "+telefon+" "+kraj_id+" "+razred_id);
        return list;
    }
}
