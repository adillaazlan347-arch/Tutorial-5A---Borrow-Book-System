public class Student {
    private String name;
    private String matric;
    private Book book;          // the book this student has borrowed (null = none)

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }

    public String getName()   { return name; }
    public String getMatric() { return matric; }
    public Book getBook()     { return book; }
    public void setBook(Book book) { this.book = book; }

    public boolean hasBorrowed() { return book != null; }

    // Used by the List button: "Name : Ali Imran (A123456)"
    public String getInfo() {
        return "Name : " + toString();
    }

    // Used by the combo box: "Ali Imran (A123456)"
    @Override
    public String toString() {
        return name + " (" + matric + ")";
    }
}
