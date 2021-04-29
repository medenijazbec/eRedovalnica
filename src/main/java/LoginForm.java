import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame
{
    private JButton prijavaButton;
    private JTextField emailField;
    private JPasswordField gesloField;
    private JPanel rootPanel;
    private JButton ustvariRacunButton;
    private JButton pozabljenoGesloButton;

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
                JOptionPane.showMessageDialog(rootPanel, "Povezava uspešna!");
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


