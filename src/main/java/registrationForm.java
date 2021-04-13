import javax.swing.*;

public class registrationForm extends JFrame{

    public registrationForm()
    {
        //this uses the form designer form
        add(rootPanel);
        setTitle("Main Page");
        setSize(400,600);


    }


    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JTextField textField3;
    private JLabel passwordField;
    private JTextField phoneField;
    private JComboBox parentcomboBox;
    private JComboBox classcomboBox;
    private JComboBox comboBox1;
    private JButton registrationButton;
    private JPanel rootPanel;
}
