import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// (d) Borrow Book GUI
public class BorrowForm extends JFrame implements ActionListener {
    private JComboBox<Student> cbStudent;
    private JComboBox<Book> cbBook;
    private JButton btnBorrow;
    private JLabel lblInfo;

    public BorrowForm() {
        setTitle("Borrow Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 200, 520, 220);

        Container pane = getContentPane();
        pane.setLayout(null);
        Font f = new Font("Tahoma", Font.BOLD, 11);

        JLabel lblStudent = new JLabel("Student Name & Matric:");
        lblStudent.setFont(f);
        lblStudent.setBounds(10, 10, 180, 16);
        pane.add(lblStudent);

        JLabel lblBook = new JLabel("Book Title & Author:");
        lblBook.setFont(f);
        lblBook.setBounds(10, 30, 180, 16);
        pane.add(lblBook);

        // combo boxes are filled with the saved objects; they display toString()
        cbStudent = new JComboBox<>(MainMenu.studentList.toArray(new Student[0]));
        cbStudent.setBounds(240, 8, 265, 20);
        pane.add(cbStudent);

        cbBook = new JComboBox<>(MainMenu.bookList.toArray(new Book[0]));
        cbBook.setBounds(240, 29, 265, 20);
        pane.add(cbBook);

        btnBorrow = new JButton("Borrow");
        btnBorrow.setBounds(225, 55, 60, 22);
        btnBorrow.setMargin(new Insets(0, 0, 0, 0));
        pane.add(btnBorrow);

        JLabel lblBorrowInfo = new JLabel("Borrow Information :");
        lblBorrowInfo.setFont(f);
        lblBorrowInfo.setBounds(10, 160, 200, 14);
        pane.add(lblBorrowInfo);

        lblInfo = new JLabel("");
        lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblInfo.setBounds(10, 175, 500, 14);
        pane.add(lblInfo);

        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Student s = (Student) cbStudent.getSelectedItem();
        Book b = (Book) cbBook.getSelectedItem();
        if (s == null || b == null) {
            JOptionPane.showMessageDialog(this,
                "Please add student and book information first.");
            return;
        }
        String msg = b.borrowBy(s);       // borrowing process
        lblInfo.setText(msg);             // show at bottom of frame
        System.out.println(msg);          // also printed to the console
    }
}
