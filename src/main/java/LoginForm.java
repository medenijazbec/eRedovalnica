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

    public LoginForm()
    {
        //this uses the form designer form
        add(rootPanel);
        setTitle("Login title");
        setSize(400,600);

        prijavaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Button goes click");
            }
        });

        ustvariRacunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(rootPane, "Button goes click");
            }
        });
    }

}


