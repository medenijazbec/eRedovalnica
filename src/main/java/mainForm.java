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


    public mainForm(String email) {

        //this uses the form designer form
        add(rootPanel);
        oseba.setText("Prijavljeni ste kot: " + email);
        setTitle("Main Page");
        setSize(400,600);

        String vsiDijaki = Database.Izpis_dijaki();
        String[] tabelaDijaki = vsiDijaki.split(",");


        dodajOcenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

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
