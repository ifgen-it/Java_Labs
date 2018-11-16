
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import practice5.Student.StudentException;
import practice5.Teacher.TeacherException;

public class MyJDialogTeacher extends JDialog {

    private MyJFrame OwnerJFrame;
    private MyJDialogTeacher TeacherForm;

    private JButton btnAccept;
    private JButton btnClear;
    private JButton btnClose;
    private JLabel lName;
    private JLabel lDegree;
    private JLabel lInfo;
    private JTextField tName;
    private JTextField tDegree;
    private Container ContentPane;

    public MyJDialogTeacher(MyJFrame owner, String title, boolean modal) {

        super(owner, title, modal);
        OwnerJFrame = owner;
        TeacherForm = this;

        init();

    }

    public void init() {

        Dimension SIZE = new Dimension(350, 150);
        Point p1 = new Point(500, 400);
        this.setSize(SIZE);
        this.setLocation(p1);

        lName = new JLabel("Name: ");
        lDegree = new JLabel("Degree: ");
        lInfo = new JLabel();
        tName = new JTextField();
        tDegree = new JTextField();
        btnAccept = new JButton("Accept");
        btnClear = new JButton("Clear");
        btnClose = new JButton("Close");

        ContentPane = getContentPane();
        ContentPane.add(lName);
        ContentPane.add(lDegree);
        ContentPane.add(lInfo);
        ContentPane.add(tName);
        ContentPane.add(tDegree);
        ContentPane.add(btnAccept);
        ContentPane.add(btnClear);
        ContentPane.add(btnClose);

        ContentPane.setLayout(null);

        lName.setSize(40, 25);
        lName.setLocation(35, 20);

        tName.setSize(120, 25);
        tName.setLocation(80, 20);

        lDegree.setSize(50, 25);
        lDegree.setLocation(210, 20);

        tDegree.setSize(45, 25);
        tDegree.setLocation(265, 20);

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

                Teacher TempTeacher = null;
                boolean Fail = false;
                try {
                    TempTeacher = new Teacher(tName.getText(), tDegree.getText());
                } catch (TeacherException ex) {
                    
                    JOptionPane.showMessageDialog(TeacherForm, ex.getMessage());
                    Fail = true;
                }
                if (Fail) {
                    lInfo.setText("NOT ACCEPTED");
                } else {
                    OwnerJFrame.Teachers.add(TempTeacher);
                    tName.setText("");
                    tDegree.setText("");
                    lInfo.setText("ACCEPTED");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tName.setText("");
                tDegree.setText("");

                lInfo.setText("CLEARED");
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherForm.dispose();
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

        tDegree.addFocusListener(new FocusListener() {
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
