package Pop3;

import Control.Parser;

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

    public Pop3() throws Exception {

    }


    public String connectAndRetreiveEmail(String strPOP3Server) throws Exception {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        s = null;
        s = (SSLSocket) ssf.createSocket(strPOP3Server, 995);
        builder = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String temp1 = "";
        return "S:" + br.readLine() + "\n";

        //authenticate();
    }


    public String authenticate(String user, String pass) throws Exception {
        bw.write("User " + user + "\n\r");
        ServerText = "C:" + "User " + user + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine() + "\n";
        bw.write("Pass " + pass + "\n\r");
        bw.flush();
        ServerText = ServerText + "C:" + "Pass " + pass + "\n";
        System.out.println("Waiting for server response...");
        temp = br.readLine();
        ServerText = ServerText + "S:" + temp + "\n";
        if (temp.substring(0, 4).equals("-ERR")) {
            ServerText = "Eror";
            return ServerText;

        } else {
            return ServerText;
        }


    }

    public String delEmail(String a) throws Exception {
        ServerText = "C:" + "DELE" + a + "\n";
        bw.write("dele " + a + "\n\r");
        bw.flush();
        temp = br.readLine();
        return ServerText + "S:" + temp + "\n";


    }


    public String showList() throws Exception {
        ServerText = "C:" + "List" + "\n";
        bw.write("List\n\r");
        bw.flush();
        temp = br.readLine();
        while (!temp.equals(".")) {
            ServerText = ServerText + "S:" + temp + "\n";

            temp = br.readLine();
        }
        return ServerText;
    }

    public String displayEmail(String a) throws Exception {
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
        return ServerText;
    }

    public String quit() throws Exception {
        bw.write("quit\n\r");
        ServerText = "C:" + "QUIT" + "\n";
        bw.flush();
        ServerText = ServerText + "S:" + br.readLine();
        s.close();
        return ServerText;
    }

    public String uidl(String a) throws Exception {
        bw.write("uidl " + a + "\n\r");
        ServerText = "C:" + "UIDL" + a + "\n";
        bw.flush();
        temp = br.readLine();
        if (temp.substring(0, 4).equals("-ERR"))
            ServerText = ServerText + temp + "\n";
        else {
            if (a.equals("")) {
                while (!temp.equals(".")) {
                    temp = br.readLine();
                    ServerText = ServerText + temp + "\n";


                }
            }
            if (!a.equals("")) {
                ServerText = ServerText + temp + "\n";
            }


        }
        return ServerText;


    }

    public String stat() throws Exception {
        bw.write("stat\n\r");
        ServerText = "C:" + "stat" + "\n";
        bw.flush();
        return ServerText = ServerText + "S:" + br.readLine();
    }

    public String noop() throws Exception {
        bw.write("noop\n\r");
        ServerText = "C:" + "NOOP" + "\n";
        bw.flush();
        return ServerText = ServerText + "S:" + br.readLine();
    }

    public String top(String a, String b) throws Exception {
        bw.write("top " + a + " " + b + "\n\r");
        ServerText = "C:" + "top" + a + " " + b + "\n";
        bw.flush();
        temp = br.readLine();
        if (temp.substring(0, 4).equals("-ERR"))
            ServerText = ServerText + temp + "\n";
        else {
            while (!temp.equals(".")) {
                temp = br.readLine();
                ServerText = ServerText + temp + "\n";


            }
        }
        //System.out.println(ServerText);
        return ServerText;

        //  ServerText = ServerText + "S:" + temp;


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