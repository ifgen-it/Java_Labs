package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnDownListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnDownListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MoveDown()) {
            myFrame.setLabelText("Moving down..", true);
        } else {
            myFrame.setLabelText("Cannot move to the down!", false);
        }
        myFrame.repaint();
    }

}
