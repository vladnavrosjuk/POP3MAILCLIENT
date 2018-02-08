import javax.swing.*;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Vies
{
    JFrame frame;
    JFrame frame2;
    JTextField enterNameServer,enterYourPassword,enterYourLogin, numberPage,numberPageDelete;
    JTextArea jTextArea;
    JButton button,displayemail,button2,deleteButton,quitButton,listButton,statButton,noopButton;
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
        button = new JButton("Connect");
        button.setBounds(10,160,100,50);
        frame.add(button);
        numberPage = new JTextField();
        numberPage.setBounds(120,300,50,50);
        frame.add(numberPage);
        numberPageDelete = new JTextField();
        numberPageDelete.setBounds(120,360,50,50);
        frame.add(numberPageDelete);
        listButton = new JButton("LIST");
        listButton.setBounds(10,240,100,50);
        frame.add(listButton);
        statButton = new JButton("STAT");
        statButton.setBounds(120,240,100,50);
        frame.add(statButton);
        button2 = new JButton("LIST + RETR");
        button2.setBounds(10,300,100,50);
        frame.add(button2);
        deleteButton = new JButton("DELE");
        deleteButton.setBounds(10,360,100,50);
        frame.add(deleteButton);
        quitButton = new JButton("QUIT");
        quitButton.setBounds(10,420,100,50);
        frame.add(quitButton);
        noopButton = new JButton("NOOP");
        noopButton.setBounds(120,420,100,50);
        frame.add(noopButton);



        jTextArea = new JTextArea();
        jTextArea.setBounds(250,10,250,500);
        frame.add(jTextArea);
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

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JButton getDisplayemail() {
        return displayemail;
    }

    public JFrame getFrame2() {
        return frame2;
    }

    public JButton getButton2() {
        return button2;
    }

    public JTextField getNumberPage() {
        return numberPage;
    }

    public JTextField getNumberPageDelete() {
        return numberPageDelete;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getListButton() {
        return listButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getStatButton() {
        return statButton;
    }

    public JButton getNoopButton() {
        return noopButton;
    }
}
