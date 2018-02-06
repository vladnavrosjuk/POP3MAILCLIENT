import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Pop3
{
    StringBuilder builder;
    String user="";
    String pass="";
    int c=13,d=10;
    SSLSocket s;
    BufferedReader br;
    BufferedWriter bw;
    String temp="";
    BufferedReader bri=new BufferedReader(new InputStreamReader(System.in));

    Pop3() throws Exception
    {
        //System.out.print("Enter pop3 server :");

       // connectAndRetreiveEmail(bri.readLine());
        connectAndRetreiveEmail("pop.mail.com");
    }



    private void connectAndRetreiveEmail(String strPOP3Server) throws Exception
    {      SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            s =null;
            s = (SSLSocket) ssf.createSocket("pop.mail.ru",995);
         builder = new StringBuilder();
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String temp1="";
        if(s.isConnected())
        {
            System.out.println("connected");
            System.out.println(br.readLine());
            while(true)
            {
                if(authenticate())
                {

                    while(!temp1.toLowerCase().equals("quit"))
                    {
                        System.out.println("\nType appropriate # for required service :");
                        System.out.println("\t1. To Read Message");
                        System.out.println("\t2. To Delete Message");
                        System.out.println("\t3. To Quit And Save Changes to Inbox");
                        System.out.println("\t4. To Quit Without Saving Changes to Inbox");
                        temp1=bri.readLine();
                        if(temp1.equals("1"))
                        {
                            displayEmail();
                        }
                        else
                        if(temp1.equals("2"))
                        {
                            delEmail();
                        }
                        else
                        if(temp1.equals("3"))
                        {
                            quit();
                            break;
                        }
                        else
                        if(temp1.equals("4"))
                        {
                            System.out.println("Quiting without saving changes to Inbox...");
                            break;
                        }

                    }
                    break;
                }
                else
                {
                    System.out.println("For giving invalid information your connection is terminated!! Logging Off...");
                    break;
                }
            }
        }

        s.close();
    }


    private boolean authenticate() throws Exception
    {
        System.out.println("\n\t\t\t\tAUTHENTICATION");
        System.out.println("\t\t\t\t--------------");
        System.out.print("Please Enter User Name : ");
        //user=bri.readLine();
        user = "testaipos@mail.ru";
        System.out.print("Please Enter password : ");
       // pass=bri.readLine();
        pass = "kolb2018";
        //System.out.println();
        bw.write("User "+user+"\n\r");
        bw.flush();
        br.readLine();
        bw.write("Pass "+pass+"\n\r");bw.flush();
        System.out.println("Waiting for server response...");
        temp=br.readLine();
        if(temp.substring(0,4).equals("-ERR"))
        {
            System.out.println("UserName or Password invalid");
            return false;
        }
        else
        {
            System.out.println(temp);
            return true;
        }

    }

    private void delEmail() throws Exception
    {
        System.out.println("\n\t\t\t\tEMAIL DELETION");
        System.out.println(  "\t\t\t\t----- --------");
        showList();
        System.out.print("Please Enter the message no. present in the list show above to delete the message : ");
        bw.write("dele "+bri.readLine()+"\n\r");
        bw.flush();
        temp=br.readLine();
        if(temp.substring(0,4).equals("-ERR"))
        {
            System.out.println("U have given invalid message no.");
        }
        else
            System.out.println(temp);
    }

    private void showList() throws Exception
    {
        System.out.println("\n\t\t\t\tEMAIL LIST");
        System.out.println(  "\t\t\t\t----- ----");
        System.out.println("List of the available email messages");
        bw.write("List\n\r");
        bw.flush();
        temp=br.readLine();
        while(!temp.equals("."))
        {
            System.out.println(temp);
            temp=br.readLine();
        }
        System.out.println(temp);

    }

    private void displayEmail() throws Exception
    {
        System.out.println("\n\t\t\t\tDISPLAYING EMAIL");
        System.out.println(  "\t\t\t\t---------- -----");
        showList();
        System.out.print("Please Enter the message no. present in the list show above to read the message : ");
        bw.write("RETR "+bri.readLine()+"\n\r");
        bw.flush();
        temp=br.readLine();
        if(temp.substring(0,4).equals("-ERR"))
        {
            System.out.println("U have given invalid message no.");
        }
        else
            while(!temp.equals("."))
            {
               // System.out.println("+++++++++++++++++++");
              //1
                //  System.out.println(temp);
                temp=br.readLine();
                builder.append(temp+"\n");
            }
        System.out.println(temp);
        System.out.println(builder);
        chek();

    }

    private void quit() throws Exception
    {
        System.out.println("Quiting and saving changes to Inbox ....");
        bw.write("quit\n\r");
        bw.flush();
        System.out.println(br.readLine());
    }

    public static void main(String args[]) throws Exception
    {
        new Pop3();
    }
    public void chek(){


        Pattern p = Pattern.compile("Delivered-To: \\w+@\\w+.\\w+");
        Matcher m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("Return-path: \\<\\w+@\\w+.\\w+\\>");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("\\d\\d \\w+ \\d\\d\\d\\d\\ \\d\\d:\\d\\d:\\d\\d");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("Subject: \\w*\\s*");
        m = p.matcher(builder);
        m.find();
        System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/html; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int start = m.start();


        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/plain; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int end = m.end();

        System.out.print(builder.substring(end,start));

    }

}