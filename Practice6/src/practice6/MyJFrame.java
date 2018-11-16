package practice6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import static practice6.Main.MAX_READER_PERMITS;
import static practice6.Main.MAX_WRITER_PERMITS;

public class MyJFrame extends JFrame {

   
    
    private JButton btnStop;
    private JButton btnSuspend;
    private JButton btnResume;
    
    private JButton btnClear;
    private JButton btnClose;
    
    private JLabel lResult;
    private JLabel lReadersResult;
    private JLabel lWritersResult;
   
    public JTextArea tResult;
    
    private JPanel Panel; 
    private JScrollPane ScrollPane;
    private String resText;
    private MySemaphore s;
    
    public MyJFrame(MySemaphore S) {
        this.s = S;
        init();

    }

    private void init() {

        
        this.setTitle("Readers & Writers data racing");
        Dimension SIZE = new Dimension(480, 640);
        Point p1 = new Point(550, 50);
        this.setSize(SIZE);
        this.setLocation(p1);

        Panel = new JPanel();
        Panel.setSize(SIZE);
        Panel.setLocation(0, 0);
        Panel.setBackground(new Color(192, 192, 192));
        add(Panel);
        Panel.setLayout(null);
        
        
        lResult = new JLabel("Readers vs Writers");
        lResult.setForeground(new Color(55, 0, 55));
        lReadersResult = new JLabel("0000");
        lReadersResult.setForeground(new Color(55, 0, 55));
        lWritersResult = new JLabel("0000");
        lWritersResult.setForeground(new Color(55, 0, 55));
        
        tResult = new JTextArea();
        
        btnStop = new JButton("Stop");
        btnSuspend = new JButton("Suspend");
        btnResume = new JButton("Resume");
        
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");

        Panel.add(lResult);
        Panel.add(lReadersResult);
        Panel.add(lWritersResult);
        
        Panel.add(btnStop);
        Panel.add(btnSuspend);
        Panel.add(btnResume);
        
        Panel.add(btnClear);
        Panel.add(btnClose);

        lResult.setSize(200, 25);
        lResult.setLocation(164, 12);
        Font fn1 = new Font(Font.DIALOG, Font.PLAIN, 17);
        lResult.setFont(fn1);
        
        lReadersResult.setSize(100, 25);
        lReadersResult.setLocation(60, 12);
        Font fn4 = new Font(Font.DIALOG, Font.PLAIN, 15);
        lReadersResult.setFont(fn4);
        lWritersResult.setSize(100, 25);
        lWritersResult.setLocation(365, 12);
        lWritersResult.setFont(fn4);
        
        

        Font fn2 = new Font("Monospaced", Font.PLAIN, 13);
        tResult.setFont(fn2);
        tResult.setText("Text will be here..");
        tResult.setBackground(new Color(55, 0, 55));
        tResult.setForeground(new Color(192, 192, 192));
        resText = "";
        tResult.setText(resText);
        
        Font fn3 = new Font(Font.DIALOG, Font.BOLD, 12);
        btnStop.setFont(fn3);
        btnSuspend.setFont(fn3);
        btnResume.setFont(fn3);
        btnClear.setFont(fn3);
        btnClose.setFont(fn3);
        
        btnStop.setForeground(new Color(55, 0, 55));
        btnSuspend.setForeground(new Color(55, 0, 55));
        btnResume.setForeground(new Color(55, 0, 55));
        btnClear.setForeground(new Color(55, 0, 55));
        btnClose.setForeground(new Color(55, 0, 55));
        
        btnStop.setSize(92, 30);
        btnSuspend.setSize(92, 30);
        btnResume.setSize(92, 30);
        btnClear.setSize(92, 30);
        btnClose.setSize(92, 30);

        btnStop.setLocation(7, 573);
        btnSuspend.setLocation(99, 573);
        btnResume.setLocation(191, 573);
        
        btnClear.setLocation(283, 573);
        btnClose.setLocation(375, 573);

        ScrollPane = new JScrollPane(tResult);
        ScrollPane.setSize(460, 516);
        ScrollPane.setLocation(7, 48);
        Panel.add(ScrollPane);
        
        
        
        handlers();

        
        String LogoPath = "/images/favicon.png";
        ImageIcon Logo = new ImageIcon(MyJFrame.class.getResource(LogoPath));
        setIconImage(Logo.getImage());
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void handlers() {

         btnStop.addActionListener((ActionEvent e) -> {
             this.s.setAllStop();
             
         });
        
         btnSuspend.addActionListener((ActionEvent e) -> {
             this.s.setAllSuspend();
             
         });
         
         btnResume.addActionListener((ActionEvent e) -> {
             this.s.setAllResume();
             
         });
        
        
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tResult.setText("");

            }
        });

        btnClose.addActionListener((ActionEvent e) -> {
            this.dispose();
        });

        }

        public void setReadersResult(int result){
            lReadersResult.setText(String.valueOf(result));
        }
        
        public void setWritersResult(int result){
            lWritersResult.setText(String.valueOf(result));
        }

}
