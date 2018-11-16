
package practice3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton2Listener implements ActionListener{

    private MyJFrame myFrame;
    
    public MyButton2Listener(MyJFrame myFrame){
        this.myFrame = myFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        myFrame.ChangeDrawBoxColor();
        myFrame.repaint();
    }
    
}
