package practice3;

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

public class MyJFrame extends JFrame {

    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private Container contentPane;
    private MyButton1Listener btn1Listner;
    private MyButton2Listener btn2Listner;
    private MyJFrameListener frListener;
    private Color DrawBoxColor;

    public MyJFrame() {
        this.setTitle("Practice3 application");
        Dimension SIZE = new Dimension(800, 600);
        Point p1 = new Point(100, 100);
        this.setSize(SIZE);
        this.setLocation(p1);

        init();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {

        contentPane = this.getContentPane();
        contentPane.setBackground(Color.yellow);
        frListener = new MyJFrameListener(this);
        this.addMouseMotionListener(frListener);

        button1 = new JButton("Change color out of draw box");
        contentPane.add(button1);
        button2 = new JButton("Change color in draw box");
        contentPane.add(button2);

        contentPane.setLayout(null);
        button1.setSize(200, 40);
        button2.setSize(200, 40);
        button1.setLocation(40, 30);
        button2.setLocation(270, 30);

        btn1Listner = new MyButton1Listener(this);
        button1.addActionListener(btn1Listner);

        btn2Listner = new MyButton2Listener(this);
        button2.addActionListener(btn2Listner);

        label1 = new JLabel("Coordinates");
        label1.setSize(200, 50);
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

        label1.setFont(f);
        label1.setLocation(50, 80);
        contentPane.add(label1);
        label1.setForeground(Color.BLUE);

        DrawBoxColor = Color.ORANGE;
    }

    void setLabelText(String msg) {
        label1.setText(msg);
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
       
        for (int i = 0; i < 12; i++) {

            g2.setColor(GetRandomColor());
            int xF1 = GetRandomFromRange(x1, x1 + wid);
            int yF1 = GetRandomFromRange(y1, y1 + hei);
            int widF = GetRandomFromRange(xF1, x1 + wid) - xF1;
            int heiF = GetRandomFromRange(yF1, y1 + hei) - yF1;

            switch (GetRandomFromRange(1, 3)) {
                case 1:
                    g2.drawOval(xF1, yF1, widF, heiF);
                    break;
                case 2:
                    g2.drawRect(xF1, yF1, widF, heiF);
                    break;
                case 3:
                    g2.drawLine(xF1, yF1, xF1 + widF, yF1 + heiF);
                    break;
                default:
                    break;
            }
        }

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
