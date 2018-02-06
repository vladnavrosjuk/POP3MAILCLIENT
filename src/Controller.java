import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Controller  {
    Vies vies;
    Pop3 pop3;
    public Controller(Vies vies,Pop3 pop3)
    {
        this.vies=vies;
        this.pop3 = pop3;
        listener();

    }
    public void listener() {
        vies.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pop3.setPass(vies.enterYourPassword.getText());
                    pop3.setUser(vies.enterYourLogin.getText());
                    pop3.connectAndRetreiveEmail(vies.enterNameServer.getText());
                }
                catch (Exception ex)
                {}

            }
        });


    }

}
