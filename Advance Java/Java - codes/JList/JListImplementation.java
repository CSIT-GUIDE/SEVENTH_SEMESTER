package JList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Author: SACHIN
 * Date: 3/16/2016.
 */
public class JListImplementation extends JFrame{
    public JListImplementation(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] words = {"Sachin","Anil","Sagar","Sarthak","Kundan","Sandesh"};
        final JList<String> jList = new JList<String>(words);
        JScrollPane scrollPane = new JScrollPane(jList);
        jList.setVisibleRowCount(4);
        final JPanel pa   = new JPanel();
        pa.add(scrollPane);
        add(pa);
        final JTextArea are = new JTextArea();
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                are.setText(jList.getSelectedValue());
                pa.add(are);
            }
        });
    }

    public static void main(String[] args) {
        JListImplementation implementation = new JListImplementation();
    }
}
