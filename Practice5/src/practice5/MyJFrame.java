package practice5;

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
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
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
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MyJFrame extends JFrame {

    private JMenuBar MyJMenuBar;
    private JMenuItem MyJMenuItStudent;
    private JMenuItem MyJMenuItFaculty;
    private JMenuItem MyJMenuItPrint;
    private Container MyContentPane;
    private JLabel MyLabel;

    public ArrayList<Student> Students;
    public ArrayList<Teacher> Teachers;

    public MyJFrame() {

        init();
        initDataStructures();

    }

    private void init() {

        this.setTitle("Practice5 application");
        Dimension SIZE = new Dimension(350, 150);
        Point p1 = new Point(500, 260);
        this.setSize(SIZE);
        this.setLocation(p1);

        MyJMenuBar = new JMenuBar();
        this.setJMenuBar(MyJMenuBar);

        MyJMenuItStudent = new JMenuItem("Student Data");
        MyJMenuBar.add(MyJMenuItStudent);
        MyJMenuItStudent.setBackground(Color.orange);

        MyJMenuItFaculty = new JMenuItem("Faculty Data");
        MyJMenuBar.add(MyJMenuItFaculty);
        MyJMenuItFaculty.setBackground(Color.ORANGE);

        MyJMenuItPrint = new JMenuItem("Print the list");
        MyJMenuBar.add(MyJMenuItPrint);
        MyJMenuItPrint.setBackground(Color.ORANGE);

        MyJMenuBar.setLayout(new GridLayout());
        MyJMenuBar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // handlers
        MyJMenuItStudent.addActionListener(new ActionListenerStudent(this));
        MyJMenuItFaculty.addActionListener(new ActionListenerFaculty(this));
        MyJMenuItPrint.addActionListener(new ActionListenerPrint(this));

        MyContentPane = this.getContentPane();
        MyContentPane.setBackground(Color.ORANGE);

        MyContentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        MyLabel = new JLabel();
        MyContentPane.add(MyLabel);

        String BackImagePath = "/images/logo.png";
        ImageIcon BackImage = new ImageIcon(MyJFrame.class.getResource(BackImagePath));    
        MyLabel.setIcon(BackImage);

//        String LogoPath = "/images/favicon.png";
//        ImageIcon Logo = new ImageIcon(MyJFrame.class.getResource(LogoPath));
//        setIconImage(Logo.getImage());

       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initDataStructures() {

        Students = new ArrayList<Student>();
        Teachers = new ArrayList<Teacher>();
    }

    private class ActionListenerStudent implements ActionListener {

        private MyJFrame MainFrame;

        public ActionListenerStudent(MyJFrame frame) {
            MainFrame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            new MyJDialogStudent(MainFrame, "Student form", true);

        }
    }

    private class ActionListenerFaculty implements ActionListener {

        private MyJFrame MainFrame;

        public ActionListenerFaculty(MyJFrame frame) {
            MainFrame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            new MyJDialogTeacher(MainFrame, "Faculty form", true);

        }
    }

    private static class ActionListenerPrint implements ActionListener {

        private MyJFrame MainFrame;

        public ActionListenerPrint(MyJFrame frame) {
            MainFrame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            new MyJDialogPrint(MainFrame, "Print the list", false);
        }
    }

    public String getStudentsAndFaculty() {

        String result = "";

        if (Students.isEmpty() && Teachers.isEmpty()) {
            result = "There is no entry in the base..";
        }
        
        if (!Students.isEmpty()) {
            result += "Students:\n";
            for (Student s : Students) {
                result += "   - " + s + "\n";
            }
        }
        
        if (!Teachers.isEmpty()) {
            result += "Teachers:\n";
            for (Teacher t : Teachers) {
                result += "   - " + t + "\n";
            }
        }
        return result;
    }

}
