import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewForm extends JFrame
{
    private JPanel rootPanel;
    private JLabel username;
    private JButton refreshButton;
    private JComboBox comboBox1;

    public viewForm(String email)
    {
        username.setText(email);
        add(rootPanel);
        setTitle("Pregled ocen");
        setSize(400,600);
        String ime = username.getText();
        String[] stars = ime.split(" ");
        int id_s = Database.Vrni_id_stars(stars[0], stars[1]);
        String dijak = Database.Vrni_dijaka(id_s);
        String ime_dijaka[] = dijak.split(" ");

        String vseOcene = Database.Vrni_ocene();
        String[] vseOcenike = vseOcene.split(" ");

        for (String a:vseOcenike)
        {
            comboBox1.addItem(a);
        }

        refreshButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here

    }
}
