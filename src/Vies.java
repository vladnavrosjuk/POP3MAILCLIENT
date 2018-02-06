import javax.swing.*;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Vies
{
    JFrame frame;
    JTextField enterNameServer,enterYourPassword,enterYourLogin;
    JButton button;
    public Vies()
    {
        frame =  new JFrame();
        frame.setLayout(null);
        frame.setSize(600,600);

        enterNameServer = new JTextField("pop.mail.ru");

        enterNameServer.setBounds(10,10,200,40);
        frame.add(enterNameServer);
        enterYourLogin = new JTextField("testaipos@mail.ru");
        enterYourLogin.setBounds(10,60,200,40);
        frame.add(enterYourLogin);
        enterYourPassword = new JTextField("kolb2018");
        enterYourPassword.setBounds(10,110,200,40);
        frame.add(enterYourPassword);
        button = new JButton("ok");
        button.setBounds(50,160,50,50);
        frame.add(button);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public JTextField getEnterNameServer() {
        return enterNameServer;
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getEnterYourPassword() {
        return enterYourPassword;
    }

    public JTextField getEnterYourLogin() {
        return enterYourLogin;
    }
}
