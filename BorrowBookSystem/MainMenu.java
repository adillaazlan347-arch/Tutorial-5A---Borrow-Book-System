import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// (a) Main Menu - the official version is on UKMFolio; this one is included so the
// whole system compiles and runs. The two lists hold the data shared by all forms.
public class MainMenu extends JFrame implements ActionListener {
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 5, 5));

        JLabel lblTitle = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        pane.add(lblTitle);
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);

        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
            new StudentForm().setVisible(true);
        else if (e.getSource() == btnBook)
            new BookForm().setVisible(true);
        else if (e.getSource() == btnBorrow)
            new BorrowForm().setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 250, 220);
        frame.setVisible(true);
    }
}
