package InternalFramer;

import javax.swing.*;

/**
 * Author: SACHIN
 * Date: 3/16/2016.
 */
public class InternalFrame extends JFrame{
    public InternalFrame(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktop = new JDesktopPane();
        JInternalFrame internalFrame = new JInternalFrame(
                "Internal Frame", true, true, true, true);
        JInternalFrame internalFrame1 = new JInternalFrame(
                "Internal Frame", true, true, true, true);
        internalFrame1.setVisible(true);
        internalFrame.setSize(100,100);
        internalFrame.setLocation(50,50);
        internalFrame1.setSize(100,100);
        internalFrame.setLocation(150,150);

        internalFrame.setVisible(true);
        desktop.add(internalFrame);
        desktop.add(internalFrame1);
        desktop.setVisible(true);
        setContentPane(desktop);
    }

    public static void main(String[] args) {
        InternalFrame i  = new InternalFrame();
    }
}
