import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.LogManager;

public class Locations extends JFrame
{
    private JTextField imeKraj;
    private JTextField postaKraj;
    private JButton izbrišiKrajButton;
    private JButton posodobiKrajButton;
    private JButton vnesiNovKrajButton;
    private JPanel Locations_view;

    public Locations()
    {
        add(Locations_view);
        setTitle("Kraji");

        izbrišiKrajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ((imeKraj.getText().length()==0) && (postaKraj.getText().length()==0))
                {
                    JOptionPane.showMessageDialog(rootPane, "Polji sta obvezni!");
                }

                else
                {
                    Database.izbrisKraj(imeKraj.getText(), postaKraj.getText());
                    JOptionPane.showMessageDialog(rootPane, "Kraj je bil uspešno izbrisan!");
                }
            }
        });
    }
}
