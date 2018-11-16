
package practice5;

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
import javax.swing.JTextField;
import practice5.Student.StudentException;

public class MyJDialogStudent extends JDialog {

    private MyJFrame OwnerJFrame;
    private MyJDialogStudent StudentForm;

    private JButton btnAccept;
    private JButton btnClear;
    private JButton btnClose;
    private JLabel lName;
    private JLabel lAge;
    private JLabel lInfo;
    private JTextField tName;
    private JTextField tAge;
    private Container ContentPane;

    public MyJDialogStudent(MyJFrame owner, String title, boolean modal) {

        super(owner, title, modal);
        OwnerJFrame = owner;
        StudentForm = this;

        init();

    }

    public void init() {

        Dimension SIZE = new Dimension(350, 150);
        Point p1 = new Point(500, 400);
        this.setSize(SIZE);
        this.setLocation(p1);

        lName = new JLabel("Name: ");
        lAge = new JLabel("Age: ");
        lInfo = new JLabel();
        tName = new JTextField();
        tAge = new JTextField();
        btnAccept = new JButton("Accept");
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");

        ContentPane = getContentPane();
        ContentPane.add(lName);
        ContentPane.add(lAge);
        ContentPane.add(lInfo);
        ContentPane.add(tName);
        ContentPane.add(tAge);
        ContentPane.add(btnAccept);
        ContentPane.add(btnClear);
        ContentPane.add(btnClose);

        ContentPane.setLayout(null);

        lName.setSize(40, 25);
        lName.setLocation(35, 20);

        tName.setSize(120, 25);
        tName.setLocation(80, 20);

        lAge.setSize(40, 25);
        lAge.setLocation(230, 20);

        tAge.setSize(35, 25);
        tAge.setLocation(265, 20);

        lInfo.setSize(120, 25);
        lInfo.setLocation(25, 90);
        Font fn = new Font(Font.DIALOG, Font.PLAIN, 12);
        lInfo.setFont(fn);

        btnAccept.setSize(90, 25);
        btnClear.setSize(90, 25);
        btnClose.setSize(90, 25);

        btnAccept.setLocation(25, 60);
        btnClear.setLocation(125, 60);
        btnClose.setLocation(225, 60);

        handlers();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void handlers() {

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Student TempStudent = null;
                boolean Fail = false;
                try {
                    TempStudent = new Student(tName.getText(), tAge.getText());
                } catch (StudentException ex) {
                    
                    JOptionPane.showMessageDialog(StudentForm, ex.getMessage());
                    Fail = true;
                }
                if (Fail) {
                    lInfo.setText("NOT ACCEPTED");
                } else {
                    OwnerJFrame.Students.add(TempStudent);
                    tName.setText("");
                    tAge.setText("");
                    lInfo.setText("ACCEPTED");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tName.setText("");
                tAge.setText("");

                lInfo.setText("CLEARED");
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentForm.dispose();
            }
        });

        tName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lInfo.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        tAge.addFocusListener(new FocusListener() {
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
