import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.LogManager;

public class Reset_password extends JFrame
{
    private JTextField EmailField;
    private JPasswordField passwordField;
    private JButton ponastaviGesloButton;
    private JPanel ResetPassword;

    public Reset_password()
    {
        add(ResetPassword);

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
                    JOptionPane.showMessageDialog(ResetPassword, "Posodobitev gesla uspešna! Vračamo vas na prijavo!");
                    LoginForm l = new LoginForm();
                    l.show();
                }
            }
        });
    }
}
