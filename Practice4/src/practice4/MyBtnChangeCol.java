package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnChangeCol implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnChangeCol(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.ChangeLineColor()) {
            myFrame.setLabelText("Line's color random changed..", true);
        } else {
            myFrame.setLabelText("Cannot change color!", false);
        }
        myFrame.repaint();
    }

}
