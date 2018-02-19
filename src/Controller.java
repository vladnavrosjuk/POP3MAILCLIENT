/**
 * Created by Владислав on 07.02.2018.
 */
public class Controller {

    Pop3 pop3;

    public Controller(Pop3 pop3) throws Exception {

        this.pop3 = pop3;


    }

    public String authorization(String login, String password) throws Exception {
        return pop3.authenticate(login, password);
    }

    public String connect(String text) throws Exception {
        return pop3.connectAndRetreiveEmail(text);

    }

    public String showlist() throws Exception {
        return pop3.showList();
    }

    public String stat() throws Exception {
        return pop3.stat();
    }

    public String uidl(String string) throws Exception {
        return pop3.uidl(string);
    }

    public String noop() throws Exception {
        return pop3.noop();
    }

    public String displayemail(String a) throws Exception {
        return pop3.displayEmail(a);
    }

    public String delete(String a) throws Exception {
        return pop3.delEmail(a);
    }

    public String quit() throws Exception {
        return pop3.quit();
    }

    public String top(String a, String b) throws Exception {
        return pop3.top(a, b);
    }


}
