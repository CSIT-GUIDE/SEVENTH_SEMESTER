package TabbedPane;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Author: SACHIN
 * Date: 3/16/2016.
 */
public class TabbedPane extends JFrame{
    public TabbedPane(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Tab1", new JButton());
        jtp.addTab("Tab2", new JButton());
        jtp.setMnemonicAt(0, KeyEvent.VK_A);
        jtp.setMnemonicAt(1, KeyEvent.VK_B);
        add(jtp);
    }

    public static void main(String[] args) {
        TabbedPane pane = new TabbedPane();
    }
}
