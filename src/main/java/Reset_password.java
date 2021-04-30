import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.LogManager;

public class Reset_password extends JFrame
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

    private JTextField EmailField;
    private JPasswordField passwordField;
    private JButton ponastaviGesloButton;
    private JPanel ResetPassword;
    private JComboBox comboBox1;

    public Reset_password()
    {
        add(ResetPassword);
        setTitle("Ponastavitev gesla");

        ponastaviGesloButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ((EmailField.getText().length()==0) || (passwordField.getText().length()==0))
                {
                    JOptionPane.showMessageDialog(ResetPassword, "Polji email in geslo sta obvezni!");
                }

                else
                {
                    String typedText = ((JTextField)comboBox1.getEditor().getEditorComponent()).getText();

                    switch (typedText)
                    {
                        case "Učitelj":
                            int resultat = Database.geslo_Ucitelji(EmailField.getText(), Kodiraj(passwordField.getText()));

                            if (resultat > 0) {
                                JOptionPane.showMessageDialog(ResetPassword, "Geslo uspešno posodobljeno! Vračamo vas na prijavo!");
                                LoginForm lll = new LoginForm();
                                lll.show();
                            }

                            else
                            {
                                EmailField.setText("");
                                passwordField.setText("");
                                JOptionPane.showMessageDialog(ResetPassword, "Učitelj z vpisanim naslovom ne obstaja! Poskusite znova!");
                            }
                            break;

                        case "Dijak":
                            int rezultat = Database.geslo_dijaki(EmailField.getText(), Kodiraj(passwordField.getText()));

                            if (rezultat > 0) {
                                JOptionPane.showMessageDialog(ResetPassword, "Geslo uspešno posodobljeno! Vračamo vas na prijavo!");
                                LoginForm lll = new LoginForm();
                                lll.show();
                            }

                            else
                            {
                                EmailField.setText("");
                                passwordField.setText("");
                                JOptionPane.showMessageDialog(ResetPassword, "Dijak z vpisanim naslovom ne obstaja! Poskusite znova!");
                            }
                            break;

                        case "Starš":
                            int rezultatt = Database.geslo_starsi(EmailField.getText(), Kodiraj(passwordField.getText()));

                            if (rezultatt > 0) {
                                JOptionPane.showMessageDialog(ResetPassword, "Geslo uspešno posodobljeno! Vračamo vas na prijavo!");
                                LoginForm lll = new LoginForm();
                                lll.show();
                            }

                            else
                            {
                                EmailField.setText("");
                                passwordField.setText("");
                                JOptionPane.showMessageDialog(ResetPassword, "Starš z vpisanim naslovom ne obstaja! Poskusite znova!");
                            }
                            break;
                    }
                }
            }
        });
    }
}
