package JList;

import javax.swing.*;

/**
 * Author: SACHIN
 * Date: 3/16/2016.
 */
public class CustomJList extends AbstractListModel{

    public static String[] wordList = {"Sachin","Anil","Sagar","Sarthak","Kundan","Sandesh"}

    @Override
    public int getSize() {
        return wordList.length;
    }

    @Override
    public Object getElementAt(int index) {
        return wordList[index];
    }
}
