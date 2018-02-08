import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Pop3 {
    StringBuilder builder;
    String user = "";
    String pass = "";
    int c = 13, d = 10;
    SSLSocket s;
    String ServerText;
    String ClientText;
    BufferedReader br;
    BufferedWriter bw;
    String temp = "";
    BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));

    Pop3() throws Exception {

    }


    public void connectAndRetreiveEmail(String strPOP3Server) throws Exception {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        s = null;
        s = (SSLSocket) ssf.createSocket(strPOP3Server, 995);
        builder = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String temp1 = "";
        ServerText = "S:" + br.readLine() + "\n";

        authenticate();
    }


    private boolean authenticate() throws Exception {
        bw.write("User " + user + "\n\r");
        ServerText = ServerText + "C:" + "User " + user + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine() + "\n";
        bw.write("Pass " + pass + "\n\r");
        bw.flush();
        ServerText = ServerText + "C:" + "Pass " + pass + "\n";
        System.out.println("Waiting for server response...");
        temp = br.readLine();
        ServerText = ServerText + "S:" + temp + "\n";
        if (temp.substring(0, 4).equals("-ERR")) {
            System.out.println("UserName or Password invalid");
            return false;
        } else {
            System.out.println(temp);
            return true;
        }

    }

    public void delEmail(String a) throws Exception {
        ServerText = "C:" + "DELE" + a + "\n";
        bw.write("dele " + a + "\n\r");
        bw.flush();
        temp = br.readLine();
        ServerText = ServerText + "S:" + temp + "\n";
        if (temp.substring(0, 4).equals("-ERR")) {
            System.out.println("U have given invalid message no.");
        } else
            System.out.println(temp);

    }

    public void showList() throws Exception {
        ServerText = "C:" + "List" + "\n";
        bw.write("List\n\r");
        bw.flush();
        temp = br.readLine();
        while (!temp.equals(".")) {
            ServerText = ServerText + "S:" + temp + "\n";

            temp = br.readLine();
        }
    }

    public void displayEmail(String a) throws Exception {
        bw.write("RETR " + a + "\n\r");
        ServerText = "C:" + "RETR" + a + "\n";
        bw.flush();
        temp = br.readLine();
        ServerText = ServerText + "S:" + temp + "\n";
        if (temp.substring(0, 4).equals("-ERR")) {
            System.out.println("U have given invalid message no.");
        } else {
            while (!temp.equals(".")) {
                temp = br.readLine();
                builder.append(temp + "\n");
            }
            Parser parser = new Parser();
            parser.parsing(builder);
            ServerText = ServerText + parser.getA();
            builder.setLength(0);
        }
    }

    public void quit() throws Exception {
        bw.write("quit\n\r");
        ServerText = "C:" + "QUIT" + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();
    }
    public void uidl(String a) throws Exception {
        bw.write("uidl "+a+"\n\r");
        ServerText = "C:" + "UIDL" + a + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();
    }

    public void stat() throws Exception {
        bw.write("stat\n\r");
        ServerText = "C:" + "stat" + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();
    }

    public void noop() throws Exception {
        bw.write("noop\n\r");
        ServerText = "C:" + "NOOP" + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();
    }

    public void top(String a, String b) throws Exception {
        bw.write("top "+a+" " + b + "\n\r");
        ServerText = "C:" + "top"+a+" " + b + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();

    }


    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getServerText() {
        return ServerText;
    }
}