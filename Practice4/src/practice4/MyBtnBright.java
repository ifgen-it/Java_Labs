package practice4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnBright implements ActionListener {

    private MyJFrame myFrame;

    public MyBtnBright(MyJFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (myFrame.MakeLineBrighter()) {
            myFrame.setLabelText("Line became brighter..", true);
        } else {
            myFrame.setLabelText("Cannot make line brighter!", false);
        }
        myFrame.repaint();
    }

}
