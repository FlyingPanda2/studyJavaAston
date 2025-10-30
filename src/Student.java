public class Student {
    private String name;
    private MyList<Book> books;

    public Student(String name, MyList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public MyList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student " + name;
    }
}
