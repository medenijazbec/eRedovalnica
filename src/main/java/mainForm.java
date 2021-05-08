import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame{
    private JComboBox predmetComboBox;
    private JTextField nazivTextField;
    private JComboBox dijakComboBox;
    private JButton dodajOcenoButton;
    private JPanel rootPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea textArea1;
    private JLabel oseba;

    public mainForm(String email)
    {

        //this uses the form designer form
        add(rootPanel);
        oseba.setText(email);
        setTitle("Main Page");
        setSize(400,600);

        String vsiRazredi = Database.izpisPredmetov();
        String[] tabelaRazredi = vsiRazredi.split(",");

        for (String a:tabelaRazredi)
        {
            predmetComboBox.addItem(a);
        }

        String vsiDijaki = Database.izpisDijakov();
        String[] tabelaDijaki = vsiDijaki.split(",");

        for (String a:tabelaDijaki)
        {
            dijakComboBox.addItem(a);
        }

        dodajOcenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String ime = oseba.getText();
                String[] Ime_Priimek = ime.split(" ");
                String naziv = nazivTextField.getText();
                String opis = textArea1.getText();
                String ocena_tip = ((JTextField)comboBox2.getEditor().getEditorComponent()).getText();
                String predmet = ((JTextField)predmetComboBox.getEditor().getEditorComponent()).getText();
                String dijak = ((JTextField)dijakComboBox.getEditor().getEditorComponent()).getText();
                String[] ime_dijaka = dijak.split(" ");
                int ucitelj_id = Database.Vrni_id_ucitelj_ocena(Ime_Priimek[0], Ime_Priimek[1]);
                int predmet_id = Database.Vrni_id_predmet_ocena(predmet);
                int dijak_id = Database.Vrni_id_dijak_ocena(ime_dijaka[0], ime_dijaka[1]);
                Database.vnosOcena(naziv, opis, ocena_tip, 5, ucitelj_id, predmet_id, dijak_id);
                JOptionPane.showMessageDialog(rootPanel, "Dodali ste oceno " + 5 + ", za dijaka/injo + " + ime_dijaka[0] + " " + ime_dijaka[1] + ", za predmet + " + predmet + ".");
            }
        });

        dodajOcenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }
}
