import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        MyList<Student> students = new MyList<>();

        MyList<Book> books1 = new MyList<>();
        books1.add(new Book("Java 8", 2014, 400));
        books1.add(new Book("Clean Code", 2008, 464));
        books1.add(new Book("Effective Java", 2018, 412));
        books1.add(new Book("Design Patterns", 1994, 395));
        books1.add(new Book("Refactoring", 2019, 450));
        students.add(new Student("Alice", books1));

        MyList<Book> books2 = new MyList<>();
        books2.add(new Book("Spring in Action", 2021, 500));
        books2.add(new Book("Java Concurrency", 2006, 700));
        books2.add(new Book("Kubernetes", 2020, 600));
        books2.add(new Book("Docker Deep Dive", 2018, 350));
        books2.add(new Book("Microservices", 2022, 420));
        students.add(new Student("Bob", books2));

        MyList<Book> books3 = new MyList<>();
        books3.add(new Book("Algorithms", 2011, 976));
        books3.add(new Book("Python Crash Course", 2016, 562));
        books3.add(new Book("You Don't Know JS", 2015, 200));
        books3.add(new Book("The Pragmatic Programmer", 2019, 352));
        books3.add(new Book("Domain-Driven Design", 2003, 529));
        students.add(new Student("Charlie", books3));

        //Стрим
        Optional<Integer> result = students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst();

        result.ifPresentOrElse(
                year -> System.out.println("Год выпуска найденной книги: " + year),
                () -> System.out.println("Такая книга отсутствует")
        );
    }
}