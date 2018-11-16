package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnClockWListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnClockWListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (myFrame.RotateClockwise()) {
            myFrame.setLabelText("Rotation clockwise..", true);
        } else {
            myFrame.setLabelText("Cannot rotate clockwise!", false);
        }
        myFrame.repaint();
    }

}
