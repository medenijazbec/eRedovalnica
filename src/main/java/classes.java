import java.io.ByteArrayInputStream;
import java.util.Date;

public class classes {

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

    public class dijaki
    {
        int id_st;
        String ime;
        String priimek;
        String email;
        String geslo;
        String telefon;
        Date datum_pridruzitve;
        Byte slika;
        int stars_id;
        int kraj_id;
        int razred_id;

        public dijaki(int _id_st, String _ime, String _priimek, String _email, String _geslo, String _telefon, Date _datum_pridruzitve,
                        int _stars_id, int _razred_id, Byte _slika, int _kraj_id)
        {
            id_st=_id_st;
            ime=_ime;
            priimek=_priimek;
            email=_email;
            geslo=_geslo;
            telefon=_telefon;
            datum_pridruzitve=_datum_pridruzitve;
            slika=_slika;
            stars_id=_stars_id;
            kraj_id=_kraj_id;
            razred_id=_razred_id;
        }

        public dijaki(int _id_st, String _ime, String _priimek, String _email, String _geslo, String _telefon, Date _datum_pridruzitve,
                        int _stars_id, int _razred_id, int _kraj_id)
        {
            id_st=_id_st;
            ime=_ime;
            priimek=_priimek;
            email=_email;
            geslo=_geslo;
            telefon=_telefon;
            datum_pridruzitve=_datum_pridruzitve;
            stars_id=_stars_id;
            kraj_id=_kraj_id;
            razred_id=_razred_id;
        }

        public String dijakiString()
        {
            String list;
            list=(id_st+" "+ime+" "+priimek+" "+email+" "+geslo+" "+telefon+" "+datum_pridruzitve+" "+slika+" "+kraj_id+" "
            +razred_id+" "+stars_id);
            return list;
        }
    }




}












