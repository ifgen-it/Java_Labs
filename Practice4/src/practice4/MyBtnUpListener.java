package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnUpListener implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnUpListener(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MoveUp()) {
            myFrame.setLabelText("Moving up..", true);
        } else {
            myFrame.setLabelText("Cannot move to the up!", false);
        }
        myFrame.repaint();
    }

}
