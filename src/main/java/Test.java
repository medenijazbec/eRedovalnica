import javax.swing.*;

public class Test extends JFrame {
    private JButton button1;
    private JPanel mainPanel;

public Test(String title)
{
    super(title);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setContentPane(mainPanel);
this.pack();

}

public static void ministring(String[] args)
{
    JFrame frame=new Test("Test app");
    frame.setVisible(true);


}
}
