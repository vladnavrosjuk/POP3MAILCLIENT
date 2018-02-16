import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Controller {
    Vies vies;
    Pop3 pop3;

    public Controller(Vies vies, Pop3 pop3) throws  Exception {
        this.vies = vies;
        this.pop3 = pop3;
        listener();

    }

    public void listener() throws Exception
    {
        vies.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    pop3.connectAndRetreiveEmail(vies.getEnterNameServer().getText());
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");

                }
                catch (Exception e1)
                {}
            }
        });
        vies.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.delEmail(vies.getNumberPageDelete().getText());
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");                }
                catch (Exception e1)
                {}
            }
        });
        vies.getQuitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.quit();
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1){}
            }
        });
        vies.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    pop3.displayEmail(vies.getNumberPage().getText());
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });
        vies.getListButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.showList();
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });

        vies.getStatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.stat();
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });
        vies.getNoopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.noop();
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });
        vies.getQuitUidl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.uidl(vies.getNumberPageUidl().getText());
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });
        vies.getTopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.top(vies.getStrTop().getText(),vies.getStrTop2().getText());
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });

        vies.getAuthorizathionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.setUser(vies.getEnterYourLogin().getText());
                    pop3.setPass(vies.getEnterYourPassword().getText());
                    pop3.authenticate();
                    vies.getjTextArea().setText(vies.getjTextArea().getText() + pop3.getServerText() + "\n");
                }
                catch (Exception e1)
                {}
            }
        });


    }
}
