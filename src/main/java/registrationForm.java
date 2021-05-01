import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class registrationForm extends JFrame
{
    public static String Kodiraj (String password)
    {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public registrationForm()
    {
        //this uses the form designer form
        add(rootPanel);
        setTitle("Registracija");
        setSize(400,600);
        classcomboBox.setEnabled(false);

        String vsiKraji = Database.izpisKraja();
        String[] tabelaKraji = vsiKraji.split(",");

        for (String a:tabelaKraji)
        {
            krajiBox.addItem(a);
        }

        String vsiRazredi = Database.izpisRazredov();
        String[] tabelaRazredi = vsiRazredi.split(",");

        for (String a:tabelaRazredi)
        {
            classcomboBox.addItem(a);
        }

        registrationButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ((nameField.getText().length()==0) || (surnameField.getText().length()==0) || (emailField.getText().length()==0)
                        || (passwordField1.getText().length()==0))
                {
                    JOptionPane.showMessageDialog(rootPanel, "Polja so obvezna!");
                }

                else
                {
                    String typedText = ((JTextField)parentcomboBox.getEditor().getEditorComponent()).getText();

                    switch (typedText)
                    {
                        case "Učitelj":
                            String razred = ((JTextField)classcomboBox.getEditor().getEditorComponent()).getText();
                            String kraj = ((JTextField)krajiBox.getEditor().getEditorComponent()).getText();
                            int id_razreda = Database.Vrni_id_ucitelj_razred(razred);
                            int id_kraja = Database.Vrni_id_ucitelj_kraj(kraj);
                            ucitelji ucitelj = new ucitelji(nameField.getText(), surnameField.getText(), emailField.getText(),
                                    Kodiraj(passwordField1.getText()), phoneField.getText(), id_razreda, id_kraja);
                            ucitelj.geslo = Kodiraj(passwordField1.getText());
                            int rezultat = Database.Ucitelji_registracija(ucitelj.ime, ucitelj.priimek,
                                    ucitelj.email, Kodiraj(passwordField1.getText()), ucitelj.telefon, ucitelj.razred_id, ucitelj.kraj_id);
                            if (rezultat > 0)
                            {
                                JOptionPane.showMessageDialog(rootPanel, "Registracija uspešna!");
                            }

                            else
                            {
                                JOptionPane.showMessageDialog(rootPanel, "Učitelj z vpisanim naslovom že obstaja! Poskusite znova!");
                                nameField.setText("");
                                surnameField.setText("");
                                emailField.setText("");
                                passwordField1.setText("");
                                phoneField.setText("");
                            }
                            break;

                        case "Dijak":
                            break;

                        case "Starš":
                            String krajj = ((JTextField)krajiBox.getEditor().getEditorComponent()).getText();
                            int id_krajaa = Database.Vrni_id_ucitelj_kraj(krajj);
                            starsi stars = new starsi(nameField.getText(), surnameField.getText(), emailField.getText(),
                                    Kodiraj(passwordField1.getText()), phoneField.getText(), id_krajaa);
                            stars.kraj_id = id_krajaa;
                            int rezultatt = Database.Starsi_registracija(stars.ime, stars.priimek,
                                    stars.email, Kodiraj(passwordField1.getText()), stars.telefon, stars.kraj_id);
                            if (rezultatt > 0)
                            {
                                JOptionPane.showMessageDialog(rootPanel, "Registracija uspešna!");
                            }

                            else
                            {
                                JOptionPane.showMessageDialog(rootPanel, "Starš z vpisanim naslovom že obstaja! Poskusite znova!");
                                nameField.setText("");
                                surnameField.setText("");
                                emailField.setText("");
                                passwordField1.setText("");
                                phoneField.setText("");
                            }
                            break;
                    }
                }
            }
        });

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        classcomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        parentcomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = ((JTextField)parentcomboBox.getEditor().getEditorComponent()).getText();

                if (text == "Starš")
                {
                    classcomboBox.setEnabled(false);
                }

                else
                {
                    classcomboBox.setEnabled(true);
                }
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
    private JPasswordField passwordField1;
}
