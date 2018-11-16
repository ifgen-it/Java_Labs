
package practice3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton1Listener implements ActionListener{

    private MyJFrame myFrame;
    
    public MyButton1Listener(MyJFrame myFrame){
        this.myFrame = myFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Color col = MyJFrame.GetRandomColor();
        myFrame.getContentPane().setBackground(col);
        myFrame.repaint();
    }
    
}
