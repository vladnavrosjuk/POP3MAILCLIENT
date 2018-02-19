package Control;

import Control.Controller;
import Pop3.Pop3;
import View.Vies;

/**
 * Created by Владислав on 07.02.2018.
 */
public class EntryPoint {
    public static void main(String[] args) throws  Exception {
        Pop3 pop3 = new Pop3();
        Controller controller = new Controller(pop3);
        Vies vies = new Vies(controller);

    }
}
