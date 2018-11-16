package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnDark implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnDark(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MakeLineDarker()) {
            myFrame.setLabelText("Line became darker..", true);
        } else {
            myFrame.setLabelText("Cannot make line darker!", false);
        }
        myFrame.repaint();
    }

}
