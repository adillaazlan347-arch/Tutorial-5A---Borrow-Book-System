public class Book {
    private String title;
    private String author;
    private Student borrower;   // who borrowed it (one copy only); null = available

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public Student getBorrower() { return borrower; }

    public boolean isAvailable() { return borrower == null; }

    // Records that student s borrows this book and returns the borrow message.
    // Rules: one copy per title, one book per student.
    public String borrowBy(Student s) {
        if (!isAvailable())
            return "Sorry, the book " + title + " has already been borrowed by "
                   + borrower.getName() + ".";
        if (s.hasBorrowed())
            return "Sorry, " + s.getName() + " has already borrowed the book "
                   + s.getBook().getTitle() + ".";

        borrower = s;
        s.setBook(this);
        return s.getName() + " with matric number " + s.getMatric()
               + " has borrow a book with title " + title + ".";
    }

    // Used by the List button: "Book title : Harry Potter (Author : J K Rowling)"
    public String getInfo() {
        return "Book title : " + title + " (Author : " + author + ")";
    }

    // Used by the combo box: "Harry Potter (J K Rowling)"
    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
