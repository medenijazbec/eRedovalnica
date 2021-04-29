import java.io.ByteArrayInputStream;
import java.util.Date;

public class ocene
{
    int id_c;
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

    public ocene(int _id_c, String _ime, String _priimek, String _email, String _geslo, String _telefon, Date _datum_pridruzitve,
                 int _stars_id, int _razred_id, Byte _slika, int _kraj_id) {
        id_c = _id_c;
        ime = _ime;
        priimek = _priimek;
        email = _email;
        geslo = _geslo;
        telefon = _telefon;
        datum_pridruzitve = _datum_pridruzitve;
        slika = _slika;
        stars_id = _stars_id;
        kraj_id = _kraj_id;
        razred_id = _razred_id;
    }

    public ocene(int _id_c, String _ime, String _priimek, String _email, String _geslo, String _telefon, Date _datum_pridruzitve,
                 int _stars_id, int _razred_id, int _kraj_id) {
        id_c = _id_c;
        ime = _ime;
        priimek = _priimek;
        email = _email;
        geslo = _geslo;
        telefon = _telefon;
        datum_pridruzitve = _datum_pridruzitve;
        stars_id = _stars_id;
        kraj_id = _kraj_id;
        razred_id = _razred_id;
    }

    public String oceneString() {
        String list;
        list = (id_c + " " + ime + " " + priimek + " " + email + " " + geslo + " " + telefon + " " + datum_pridruzitve + " " + slika + " " + kraj_id + " "
                + razred_id + " " + stars_id);
        return list;
    }
}
