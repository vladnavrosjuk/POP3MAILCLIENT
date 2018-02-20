package Lab.Aipos1.Pop3.View;

import Lab.Aipos1.Pop3.Control.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Владислав on 07.02.2018.
 */
public class Vies {
    JFrame frame;
    JFrame frame2;
    JTextField enterNameServer;
    JTextField enterYourPassword;
    JTextField enterYourLogin;
    JTextField numberPage;
    JTextField numberPageDelete;
    JTextField numberPageUidl;
    JTextField strTop;
    JTextField strTop2;
    JTextArea jTextArea;
    JButton button;
    JButton displayemail;
    JButton deleteButton;
    JButton button2;
    JButton listButton;
    JButton quitButton;
    JButton noopButton;
    JButton statButton;
    JButton quitUidl;
    JButton topButton;
    JButton  authorizathionButton;
    private Controller controller;
    Button buttonredi = new Button();

    public Vies(Controller controller)

    {
        this.controller = controller;

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.black);
        jPanel.setBounds(250, 10, 500, 700);


        frame = new JFrame();
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setSize(800, 730);
        enterNameServer = new JTextField("pop.mail.ru");
        enterNameServer.setBounds(10, 10, 200, 40);
        frame.add(enterNameServer);
        enterYourLogin = new JTextField("testaipos@mail.ru");
        enterYourLogin.setBounds(10, 60, 200, 40);
        frame.add(enterYourLogin);
        enterYourPassword = new JTextField("labaaipos1");
        enterYourPassword.setBounds(10, 110, 200, 40);
        enterYourPassword.setBackground(Color.black);

        frame.add(enterYourPassword);
        button = new JButton("Connect");
        button.setBounds(10, 160, 100, 50);
        buttonredi.createButtin(button);
        frame.add(button);
        authorizathionButton = new JButton("Autoriz");
        authorizathionButton.setBounds(120, 160, 100, 50);
        frame.add(authorizathionButton);

        numberPage = new JTextField();
        numberPage.setBounds(120, 300, 50, 50);
        frame.add(numberPage);
        numberPageDelete = new JTextField();
        numberPageDelete.setBounds(120, 360, 50, 50);
        frame.add(numberPageDelete);
        numberPageUidl = new JTextField();
        numberPageUidl.setBounds(120, 420, 50, 50);
        frame.add(numberPageUidl);
        strTop = new JTextField();
        strTop.setBounds(120, 480, 50, 50);
        frame.add(strTop);
        strTop2 = new JTextField();
        strTop2.setBounds(170, 480, 50, 50);
        frame.add(strTop2);

        listButton = new JButton("LIST");
        listButton.setBounds(10, 240, 100, 50);
        frame.add(listButton);

        statButton = new JButton("STAT");
        statButton.setBounds(120, 240, 100, 50);
        frame.add(statButton);

        button2 = new JButton("RETR");
        button2.setBounds(10, 300, 100, 50);
        frame.add(button2);

        deleteButton = new JButton("DELE");
        deleteButton.setBounds(10, 360, 100, 50);
        frame.add(deleteButton);

        quitButton = new JButton("QUIT");
        quitButton.setBounds(10, 640, 100, 50);
        frame.add(quitButton);

        quitUidl = new JButton("UIDL");
        quitUidl.setBounds(10, 420, 100, 50);
        frame.add(quitUidl);


        topButton = new JButton("TOP");
        topButton.setBounds(10, 480, 100, 50);
        frame.add(topButton);


        noopButton = new JButton("NOOP");
        noopButton.setBounds(120, 640, 100, 50);
        noopButton.setBackground(Color.black);
        frame.add(noopButton);


        jTextArea = new JTextArea(40, 43);
        jTextArea.setBackground(Color.black);
        jTextArea.setDisabledTextColor(Color.red);
        Color color = new Color(16, 189, 0);
        jTextArea.setForeground(color);
        //jTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(jTextArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        jPanel.add(scroll);
        jPanel.setForeground(Color.red);
        jPanel.setBorder(new TitledBorder(new EtchedBorder(), "TERMINAL"));
        frame.add(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        listener();
        createJButton();
        createTextField();
    }



    public void createJButton() {
        buttonredi.createButtin(button2);
        buttonredi.createButtin(deleteButton);
        buttonredi.createButtin(quitButton);
        buttonredi.createButtin(listButton);
        buttonredi.createButtin(statButton);
        buttonredi.createButtin(noopButton);
        buttonredi.createButtin(quitUidl);
        buttonredi.createButtin(topButton);
        buttonredi.createButtin(authorizathionButton);
        buttonredi.createButtin(authorizathionButton);
        buttonredi.createButtin(noopButton);
    }

    public void createTextField() {
        buttonredi.createText(enterNameServer);
        buttonredi.createText(enterYourPassword);
        buttonredi.createText(enterYourLogin);
        buttonredi.createText(numberPage);
        buttonredi.createText(numberPageDelete);
        buttonredi.createText(numberPageUidl);
        buttonredi.createText(strTop);
        buttonredi.createText(strTop2);
    }

    public void listener() {
        authorizathionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.authorization(enterYourLogin.getText(), enterYourPassword.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in authoriz");
                }
            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String showlist = controller.showlist();
                    jTextArea.setText(jTextArea.getText() + showlist + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in show list ");

                }
            }
        });
        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String stat = controller.stat();
                    jTextArea.setText(jTextArea.getText() + stat + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in show stat ");

                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.delete(numberPageDelete.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                    System.out.println(connect);
                } catch (Exception e1) {
                    jTextArea.setText("Eror in delete");
                }


            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.connect(enterNameServer.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in connect");
                }


            }
        });
        noopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.noop();
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in noop");
                    System.out.println("");
                }


            }
        });
        topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.top(strTop.getText(), strTop2.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");

                } catch (Exception e1) {
                    jTextArea.setText("Eror in top");
                }
            }
        });
        quitUidl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.uidl(numberPageUidl.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in uidl");
                }


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.displayemail(numberPage.getText());
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                } catch (Exception e1) {
                    jTextArea.setText("Eror in retr");
                }


            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String connect = controller.quit();
                    jTextArea.setText(jTextArea.getText() + connect + "\n");
                   /* Thread.sleep(10000);
                    System.exit(0);*/

                } catch (Exception e1) {
                    jTextArea.setText("Eror in quit");
                }
            }
        });

    }


}
