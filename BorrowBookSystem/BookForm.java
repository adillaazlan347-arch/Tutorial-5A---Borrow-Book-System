import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// (c) Add Book Info GUI
public class BookForm extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;

    public BookForm() {
        setTitle("Add Book Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // close only this form
        setBounds(150, 150, 400, 220);

        Container pane = getContentPane();
        pane.setLayout(null);                                 // absolute positioning
        Font f = new Font("Tahoma", Font.BOLD, 11);

        JLabel lblTitle = new JLabel("Book Title:");
        lblTitle.setFont(f);
        lblTitle.setBounds(10, 10, 150, 16);
        pane.add(lblTitle);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(f);
        lblAuthor.setBounds(10, 28, 150, 16);
        pane.add(lblAuthor);

        txtTitle = new JTextField();
        txtTitle.setBounds(200, 9, 175, 18);
        pane.add(txtTitle);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(200, 27, 175, 18);
        pane.add(txtAuthor);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(140, 50, 55, 22);
        btnAdd.setMargin(new Insets(0, 0, 0, 0));
        pane.add(btnAdd);

        btnList = new JButton("List");
        btnList.setBounds(200, 50, 55, 22);
        btnList.setMargin(new Insets(0, 0, 0, 0));
        pane.add(btnList);

        JLabel lblBooks = new JLabel("Books:");
        lblBooks.setFont(f);
        lblBooks.setBounds(10, 85, 150, 16);
        pane.add(lblBooks);

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
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter both book title and author.");
                return;
            }
            MainMenu.bookList.add(new Book(title, author));      // create & save
            txtTitle.setText("");
            txtAuthor.setText("");
            txtTitle.requestFocus();
        } else if (e.getSource() == btnList) {
            txtArea.setText("");
            for (Book b : MainMenu.bookList)
                txtArea.append(b.getInfo() + "\n");
        }
    }
}
