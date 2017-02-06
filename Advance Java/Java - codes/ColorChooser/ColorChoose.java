package ColorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: SACHIN
 * Date: 3/15/2016.
 */
public class ColorChoose extends JFrame{
    JPanel panel;
    public ColorChoose(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setVisible(true);
        panel = new JPanel();
        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = JColorChooser.showDialog(panel,
                        "Set background", Color.white);
                panel.setBackground(backgroundColor);
            }
        });
        panel.add(button);
        add(panel);
    }

    public static void main(String[] args) {
        ColorChoose colorChoose = new ColorChoose();
    }
}
