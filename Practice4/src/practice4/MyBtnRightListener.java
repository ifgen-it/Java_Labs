package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnRightListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnRightListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MoveRight()) {
            myFrame.setLabelText("Moving right..", true);
        } else {
            myFrame.setLabelText("Cannot move to the right!", false);
        }
        myFrame.repaint();
    }

}
