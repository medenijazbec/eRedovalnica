import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrationForm extends JFrame{

    public registrationForm()
    {
        //this uses the form designer form
        add(rootPanel);
        setTitle("Main Page");
        setSize(400,600);

        String vsiKraji = Database.izpisKraja();
        String[] tabelaKraji = vsiKraji.split(",");

        for (String a:tabelaKraji)
        {
            krajiBox.addItem(a);
        }

        registrationButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ((nameField.getText().length()==0) && (surnameField.getText().length()==0) && (emailField.getText().length()==0)
                    && (textField3.getText().length()==0) && (passwordField.getText().length()==0) && (phoneField.getText().length()==0))
                {
                    JOptionPane.showMessageDialog(rootPanel, "Polja so obvezna!");
                }

                else
                {
                    switch (parentcomboBox.getToolTipText())
                    {
                        case "Starš":

                            break;

                        case "Učitelj":
                            break;

                        case "Dijak":
                            break;
                    }
                }
            }
        });

        preglejKrajeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locations l = new Locations();
                l.show();
            }
        });
    }


    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JTextField textField3;
    private JLabel passwordField;
    private JTextField phoneField;
    private JComboBox parentcomboBox;
    private JComboBox classcomboBox;
    private JComboBox krajiBox;
    private JButton registrationButton;
    private JPanel rootPanel;
    private JButton preglejKrajeButton;
}
