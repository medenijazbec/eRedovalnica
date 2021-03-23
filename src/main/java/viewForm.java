import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewForm extends JFrame{
    private JPanel rootPanel;
    private JTable gradeTable;
    private JLabel username;
    private JButton refreshButton;

    public viewForm() {

        add(rootPanel);
        setTitle("Main Page");
        setSize(400,600);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Button goes click");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
