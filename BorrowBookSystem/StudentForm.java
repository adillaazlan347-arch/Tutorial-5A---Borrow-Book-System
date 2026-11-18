import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// (b) Add Student Info GUI
public class StudentForm extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;

    public StudentForm() {
        setTitle("Add Student Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // close only this form
        setBounds(150, 150, 400, 220);

        Container pane = getContentPane();
        pane.setLayout(null);                                 // absolute positioning
        Font f = new Font("Tahoma", Font.BOLD, 11);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(f);
        lblName.setBounds(10, 10, 150, 16);
        pane.add(lblName);

        JLabel lblMatric = new JLabel("Matric:");
        lblMatric.setFont(f);
        lblMatric.setBounds(10, 28, 150, 16);
        pane.add(lblMatric);

        txtName = new JTextField();
        txtName.setBounds(200, 9, 175, 18);
        pane.add(txtName);

        txtMatric = new JTextField();
        txtMatric.setBounds(200, 27, 175, 18);
        pane.add(txtMatric);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(140, 50, 55, 22);
        btnAdd.setMargin(new Insets(0, 0, 0, 0));
        pane.add(btnAdd);

        btnList = new JButton("List");
        btnList.setBounds(200, 50, 55, 22);
        btnList.setMargin(new Insets(0, 0, 0, 0));
        pane.add(btnList);

        JLabel lblStudents = new JLabel("Students:");
        lblStudents.setFont(f);
        lblStudents.setBounds(10, 85, 150, 16);
        pane.add(lblStudents);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 102, 365, 70);
        pane.add(scroll);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (name.isEmpty() || matric.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter both name and matric.");
                return;
            }
            MainMenu.studentList.add(new Student(name, matric)); // create & save
            txtName.setText("");
            txtMatric.setText("");
            txtName.requestFocus();
        } else if (e.getSource() == btnList) {
            txtArea.setText("");
            for (Student s : MainMenu.studentList)
                txtArea.append(s.getInfo() + "\n");
        }
    }
}
