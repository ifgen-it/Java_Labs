package practice3;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyJFrameListener implements MouseMotionListener {

    private MyJFrame myFrame;

    public MyJFrameListener(MyJFrame myFrame) {
        this.myFrame = myFrame;

    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Point p = me.getPoint();
        String NewText = "X: " + p.x + " Y: " + p.y;
        myFrame.setLabelText(NewText);
        myFrame.repaint();
    }

}
