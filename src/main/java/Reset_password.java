import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset_password
{
    private JTextField EmailField;
    private JPasswordField passwordField;
    private JButton ponastaviGesloButton;
    private JPanel ResetPassword;

    public Reset_password()
    {
        ponastaviGesloButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String email = EmailField.getText();
                String password = EmailField.getText();

                if ((email == "") || (password == ""))
                {
                    JOptionPane.showMessageDialog(ResetPassword, "Polji email in geslo sta obvezni!");
                }

                else
                {

                }
            }
        });
    }
}
