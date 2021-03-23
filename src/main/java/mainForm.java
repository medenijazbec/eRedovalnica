import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame{
    private JComboBox uciteljComboBox;
    private JComboBox predmetComboBox;
    private JTextField nazivTextField;
    private JTextField opisTextField;
    private JTextField datumOddajeTextField;
    private JTextField tipOceneTextField;
    private JTextField ocenaTextField;
    private JComboBox dijakComboBox;
    private JButton dodajOcenoButton;
    private JPanel rootPanel;


    public mainForm() {

        //this uses the form designer form
        add(rootPanel);
        setTitle("Main Page");
        setSize(400,600);


        dodajOcenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(rootPanel, "Button goes click");
            }
        });
    }
}
