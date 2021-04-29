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
        setTitle("Login title");
        setSize(400,600);

        prijavaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Database.connect();
                JOptionPane.showMessageDialog(rootPanel, "Geslo je: " + Kodiraj(gesloField.getText()));
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


