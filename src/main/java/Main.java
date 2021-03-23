import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);

                mainForm MainForm = new mainForm();
                MainForm.setVisible(true);

                viewForm ViewForm = new viewForm();
                ViewForm.setVisible(true);

            }
        });







    }


}