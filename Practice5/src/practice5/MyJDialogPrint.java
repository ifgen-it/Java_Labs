package practice5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import practice5.Student.StudentException;

public class MyJDialogPrint extends JDialog {

    private MyJFrame OwnerJFrame;
    private MyJDialogPrint PrintForm;

    private JButton btnUpdate;
    private JButton btnClear;
    private JButton btnClose;
    private JLabel lResult;
    private JLabel lInfo;
    private JTextArea tResult;
    
    private JPanel Panel; 
    private JScrollPane ScrollPane;
    
    public MyJDialogPrint(MyJFrame owner, String title, boolean modal) {

        super(owner, title, modal);
        OwnerJFrame = owner;
        PrintForm = this;

        init();

    }

    public void init() {

        Dimension SIZE = new Dimension(350, 250);
        Point p1 = new Point(859, 260);
        this.setSize(SIZE);
        this.setLocation(p1);

        Panel = new JPanel();
        Panel.setSize(350, 250);
        Panel.setLocation(0, 0);
        Panel.setBackground(new Color(18, 30, 49));
        add(Panel);
        Panel.setLayout(null);
        
        
        lResult = new JLabel("Students "+ String.valueOf('\u2615') + " Faculty");
        lResult.setForeground(Color.ORANGE);
        
        lInfo = new JLabel();
        lInfo.setForeground(new Color(48, 162, 18));
        
        tResult = new JTextArea();
        btnUpdate = new JButton("Update");
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");

        Panel.add(lResult);
        Panel.add(lInfo);
        
        Panel.add(btnUpdate);
        Panel.add(btnClear);
        Panel.add(btnClose);

        lResult.setSize(200, 25);
        lResult.setLocation(100, 10);
        Font fn1 = new Font(Font.DIALOG, Font.PLAIN, 16);
        lResult.setFont(fn1);

        tResult.setText(OwnerJFrame.getStudentsAndFaculty());

        lInfo.setSize(120, 25);
        lInfo.setLocation(25, 190);
        Font fn2 = new Font(Font.DIALOG, Font.PLAIN, 12);
        lInfo.setFont(fn2);

        btnUpdate.setSize(90, 25);
        btnClear.setSize(90, 25);
        btnClose.setSize(90, 25);

        btnUpdate.setLocation(25, 160);
        btnClear.setLocation(125, 160);
        btnClose.setLocation(225, 160);

        ScrollPane = new JScrollPane(tResult);
        ScrollPane.setSize(288, 95);
        ScrollPane.setLocation(26, 44);
        Panel.add(ScrollPane);
        
        
        
        handlers();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void handlers() {

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tResult.setText(OwnerJFrame.getStudentsAndFaculty());
                lInfo.setText("UPDATED");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tResult.setText("");

                lInfo.setText("CLEARED");
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintForm.dispose();
            }
        });

        tResult.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lInfo.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }
}
