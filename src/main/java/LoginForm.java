import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginForm extends JFrame
{
    private JButton prijavaButton;
    private JTextField emailField;
    private JPasswordField gesloField;
    private JPanel rootPanel;
    private JButton ustvariRacunButton;
    private JButton pozabljenoGesloButton;
    private JComboBox izbiraBox;

    public static String Kodiraj (String password) {
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

    public LoginForm()
    {
        //this uses the form designer form
        add(rootPanel);
        setTitle("Login");
        setSize(400,600);

        prijavaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ((emailField.getText().length()==0) || (gesloField.getText().length()==0))
                {
                    JOptionPane.showMessageDialog(rootPanel, "Polji sta obvezni!");
                }

                else
                    {
                        String Status = ((JTextField)izbiraBox.getEditor().getEditorComponent()).getText();

                        switch (Status)
                        {
                            case "Učitelj":
                                int ucitelj_id = Database.Prijava_ucitelji(emailField.getText(), Kodiraj(gesloField.getText()));
                                if (ucitelj_id != 0)
                                {
                                    JOptionPane.showMessageDialog(rootPanel, "Prijava uspešna!");
                                    ucitelji u = new ucitelji();
                                    u.email = emailField.getText();
                                    String email_u = Database.Ucitelj_seja(u.email);
                                    mainForm m = new mainForm(email_u);
                                    m.show();
                                }

                                else
                                    {
                                        JOptionPane.showMessageDialog(rootPanel, "Prijava ni uspešna! Poskusite znova!");
                                }
                                break;

                            case "Dijak":
                                int dijak_id = Database.Prijava_dijaki(emailField.getText(), Kodiraj(gesloField.getText()));
                                if (dijak_id != 0)
                                {
                                    JOptionPane.showMessageDialog(rootPanel, "Prijava uspešna!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(rootPanel, "Prijava ni uspešna! Poskusite znova!");
                                }
                                break;

                            case "Starš":
                                int stars_id = Database.Prijava_starsi(emailField.getText(), Kodiraj(gesloField.getText()));
                                if (stars_id != 0)
                                {
                                    JOptionPane.showMessageDialog(rootPanel, "Prijava uspešna!");
                                    starsi s = new starsi();
                                    s.email = emailField.getText();
                                    String email_s = Database.Starsi_seja(s.email);
                                    viewForm v = new viewForm(email_s);
                                    v.show();
                                }

                                else
                                {
                                    JOptionPane.showMessageDialog(rootPanel, "Prijava ni uspešna! Poskusite znova!");
                                }
                                break;
                        }
                }
            }
        });

        ustvariRacunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                registrationForm r = new registrationForm();
                r.show();
            }
        });

        pozabljenoGesloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Reset_password reset = new Reset_password();
                reset.show();
            }
        });
    }
}


