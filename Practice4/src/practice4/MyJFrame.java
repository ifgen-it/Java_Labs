package practice4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyJFrame extends JFrame {

       
    private JButton btnLeft;
    private JButton btnRight;
    private JButton btnUp;
    private JButton btnDown;
    private JButton btnClockW;
    private JButton btnCntClockW;
    private JButton btnBright;
    private JButton btnDark;
    private JButton btnChangeCol;
    
    private JLabel label1;
    private Container contentPane;
    private Color DrawBoxColor;
    private Color LineColor;

    private Point p1;
    private Point p2;

    //DrawBox
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //
    private static int MoveDelta = 20;
    private static double RotateDelta = Math.PI / 8;
    private static double LineLength;

    public MyJFrame() {

        init();
    }

    private void init() {

        this.setTitle("Practice4 application");
        Dimension SIZE = new Dimension(800, 600);
        Point p1 = new Point(100, 100);
        this.setSize(SIZE);
        this.setLocation(p1);
        
             
        contentPane = this.getContentPane();
        contentPane.setBackground(Color.yellow);
        contentPane.setLayout(null);
        
        btnLeft = new JButton("Left");
        btnRight = new JButton("Right");
        btnUp = new JButton("Up");
        btnDown = new JButton("Down");
        btnClockW = new JButton("ClockWise");
        btnCntClockW = new JButton("CounterClockWise");
        btnBright = new JButton("Brighter");
        btnDark = new JButton("Darker");
        btnChangeCol = new JButton("Change line's color");
        
        contentPane.add(btnLeft);
        contentPane.add(btnRight);
        contentPane.add(btnUp);
        contentPane.add(btnDown);
        contentPane.add(btnClockW);
        contentPane.add(btnCntClockW);
        contentPane.add(btnBright);
        contentPane.add(btnDark);
        contentPane.add(btnChangeCol);
        
        btnLeft.setSize(70, 30);
        btnRight.setSize(70, 30);
        btnUp.setSize(70, 30);
        btnDown.setSize(70, 30);
        btnClockW.setSize(140, 30);
        btnCntClockW.setSize(140, 30);
        btnBright.setSize(80, 30);
        btnDark.setSize(80, 30);
        btnChangeCol.setSize(190, 30);
        
        btnLeft.setLocation(60, 60);
        btnRight.setLocation(250, 60);
        btnUp.setLocation(155, 30);
        btnDown.setLocation(155, 90);
        btnClockW.setLocation(360, 30);
        btnCntClockW.setLocation(360, 90);
        btnBright.setLocation(540, 30);
        btnDark.setLocation(650, 30);
        btnChangeCol.setLocation(540, 90);
              
        btnLeft.addActionListener(new MyBtnLeftListener(this));
        btnRight.addActionListener(new MyBtnRightListener(this));
        btnUp.addActionListener(new MyBtnUpListener(this));
        btnDown.addActionListener(new MyBtnDownListener(this));
        btnClockW.addActionListener(new MyBtnClockWListener(this));
        btnCntClockW.addActionListener(new MyBtnCntClockWListener(this));
        btnBright.addActionListener(new MyBtnBright(this));
        btnDark.addActionListener(new MyBtnDark(this));
        btnChangeCol.addActionListener(new MyBtnChangeCol(this));
        
        label1 = new JLabel("Action");
        label1.setSize(500, 50);
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        label1.setFont(f);
        label1.setLocation(50, 520);
        contentPane.add(label1);
        label1.setForeground(Color.BLUE);

        DrawBoxColor = Color.ORANGE;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        LineColor = GetRandomColor();
        InitLine();
    }

    public void setLabelText(String msg, boolean good) {
        label1.setText(msg);
        if (good) {
            label1.setForeground(Color.BLUE);
        }
        else{
            label1.setForeground(Color.RED);
        }
    }
    
    

    private void InitLine() {

        x1 = 50;
        y1 = 180;
        x2 = getSize().width - 2 * x1 + x1;
        y2 = getSize().height - 230 + y1;

        p1 = new Point(300, 450);
        p2 = new Point(500, 250);

        LineLength = Math.pow(
                (Math.pow((p2.y - p1.y), 2)
                + Math.pow((p2.x - p1.x), 2)), 0.5);
        System.out.println("LineLength = " + LineLength);

    }

    public boolean MakeLineBrighter(){
        
        LineColor = LineColor.brighter();
        repaint();
        return true;
    }
    
    public boolean MakeLineDarker(){
        
        LineColor = LineColor.darker();
        repaint();
        return true;
    }
    
    public boolean ChangeLineColor(){
        
        LineColor = GetRandomColor();
        repaint();
        return true;
    }
    
    public boolean MoveLeft() {
        if (p1.x - MoveDelta < x1 || p2.x - MoveDelta < x1) {
            return false;
        }
        p1 = new Point(p1.x - MoveDelta, p1.y);
        p2 = new Point(p2.x - MoveDelta, p2.y);
        return true;
    }
    
    public boolean MoveRight() {
        if (p1.x + MoveDelta > x2 || p2.x + MoveDelta > x2) {
            return false;
        }
        p1 = new Point(p1.x + MoveDelta, p1.y);
        p2 = new Point(p2.x + MoveDelta, p2.y);
        return true;
    }
    
    public boolean MoveUp() {
        if (p1.y - MoveDelta < y1 || p2.y - MoveDelta < y1) {
            return false;
        }
        p1 = new Point(p1.x, p1.y - MoveDelta);
        p2 = new Point(p2.x, p2.y - MoveDelta);
        return true;
    }
    
    public boolean MoveDown() {
        if (p1.y + MoveDelta > y2 || p2.y + MoveDelta > y2) {
            return false;
        }
        p1 = new Point(p1.x, p1.y + MoveDelta);
        p2 = new Point(p2.x, p2.y + MoveDelta);
        return true;
    }
       
    public boolean RotateClockwise() {

        int x0 = (p1.x + p2.x) / 2;
        int y0 = (p1.y + p2.y) / 2;
        double tngF1 = (double) (p1.y - p2.y) / (p2.x - p1.x);
        double F1 = Math.atan(tngF1);
        if (F1 < 0) {
            F1 = Math.PI + F1;
        }
        double F2 = F1 - RotateDelta;
        int newY = (int) (Math.sin(F2) * 0.5 * LineLength);
        int newX = (int) (Math.cos(F2) * 0.5 * LineLength);

        Point p1Temp = new Point(x0 - newX, y0 + newY);
        Point p2Temp = new Point(x0 + newX, y0 - newY);

        if (p1Temp.x < x1 || p1Temp.x > x2
                || p2Temp.x < x1 || p2Temp.x > x2
                || p1Temp.y < y1 || p1Temp.y > y2
                || p2Temp.y < y1 || p2Temp.y > y2) {
            return false;
        }

        p1 = p1Temp;
        p2 = p2Temp;
        return true;
    }
    
    public boolean RotateCntClockwise() {

        int x0 = (p1.x + p2.x) / 2;
        int y0 = (p1.y + p2.y) / 2;
        double tngF1 = (double) (p1.y - p2.y) / (p2.x - p1.x);
        double F1 = Math.atan(tngF1);
        if (F1 < 0) {
            F1 = Math.PI + F1;
        }
        double F2 = F1 + RotateDelta;
        int newY = (int) (Math.sin(F2) * 0.5 * LineLength);
        int newX = (int) (Math.cos(F2) * 0.5 * LineLength);

        Point p1Temp = new Point(x0 - newX, y0 + newY);
        Point p2Temp = new Point(x0 + newX, y0 - newY);

        if (p1Temp.x < x1 || p1Temp.x > x2
                || p2Temp.x < x1 || p2Temp.x > x2
                || p1Temp.y < y1 || p1Temp.y > y2
                || p2Temp.y < y1 || p2Temp.y > y2) {
            return false;
        }

        p1 = p1Temp;
        p2 = p2Temp;
        return true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        int x1 = 50;
        int y1 = 180;
        int wid = getSize().width - 2 * x1;
        int hei = getSize().height - 230;

        g2.setColor(DrawBoxColor);
        g2.fillRect(x1, y1, wid, hei);

        BasicStroke pen2 = new BasicStroke(8);
        g2.setStroke(pen2);
        g2.setColor(LineColor);
        g2.drawLine(p1.x, p1.y, p2.x, p2.y);

    }

    public static Color GetRandomColor() {

        Color col = new Color(
                (int) Math.round(Math.random() * 255),
                (int) Math.round(Math.random() * 255),
                (int) Math.round(Math.random() * 255));
        return col;
    }

    public void ChangeDrawBoxColor() {
        DrawBoxColor = GetRandomColor();
        repaint();
    }

    public static int GetRandomFromRange(int x1, int x2) {

        return x1 + (int) ((x2 - x1 + 1) * Math.random());
    }
}
