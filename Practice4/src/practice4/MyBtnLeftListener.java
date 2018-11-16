package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnLeftListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnLeftListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MoveLeft()) {
            myFrame.setLabelText("Moving left..", true);
        } else {
            myFrame.setLabelText("Cannot move to the left!", false);
        }
        myFrame.repaint();
    }

}
