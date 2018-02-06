/**
 * Created by Владислав on 07.02.2018.
 */
public class EntryPoint {
    public static void main(String[] args) throws  Exception {
        Vies vies = new Vies();
        Pop3 pop3 = new Pop3();

        Controller controller = new Controller(vies,pop3);
    }
}
