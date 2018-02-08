import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Parser {
    String a= "";
    public Parser(){}
    public void parsing(StringBuilder builder){
        Pattern p = Pattern.compile("Delivered-To: \\w+@\\w+.\\w+");

        Matcher m = p.matcher(builder);

        m.find();
        a = a + builder.substring(m.start(),m.end())+ "\n";
       // System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("Return-path: \\<\\w+@\\w+.\\w+\\>");
        m = p.matcher(builder);
        m.find();
        a = a + builder.substring(m.start(),m.end())+ "\n";
       // System.out.println(builder.substring(m.start(),m.end()));
        p = Pattern.compile("\\d\\d \\w+ \\d\\d\\d\\d\\ \\d\\d:\\d\\d:\\d\\d");
        m = p.matcher(builder);
        m.find();
        a = a + builder.substring(m.start(),m.end())+ "\n";
        //System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("Subject: \\w*\\s*");
        m = p.matcher(builder);
        m.find();
        a = a + builder.substring(m.start(),m.end())+ "\n";
       // System.out.println(builder.substring(m.start(),m.end()));

        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/html; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int start = m.start();


        p = Pattern.compile("(--\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w)\\nContent-Type: text\\/plain; charset=\"UTF-8");
        m = p.matcher(builder);
        m.find();
        int end = m.end() + 1;
    a = a + builder.substring(end,start)+ "\n";


       // return (builder.substring(end,start));
    }

    public String getA() {
        return a;
    }
}
