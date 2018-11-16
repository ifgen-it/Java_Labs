package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnCntClockWListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnCntClockWListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (myFrame.RotateCntClockwise()) {
            myFrame.setLabelText("Rotation counterclockwise..", true);
        } else {
            myFrame.setLabelText("Cannot rotate counterclockwise!", false);
        }
        myFrame.repaint();
    }

}
