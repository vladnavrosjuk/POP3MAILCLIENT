import javax.swing.*;
import java.awt.*;

/**
 * Created by Владислав on 15.02.2018.
 */
public class Button {
    public  Button(){

    }
    public void createButtin(JButton button){
        button.setBackground(Color.black);
        Color color = new Color(16, 189, 0);
        button.setForeground(color);
        button.setBorder(BorderFactory.createLineBorder(color));
    }

    public void createText(JTextField button){
        button.setBackground(Color.black);
        Color color = new Color(189, 14, 0);
        button.setForeground(color);
        button.setBorder(BorderFactory.createLineBorder(color));
    }
}
