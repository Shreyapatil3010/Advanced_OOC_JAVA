import LibraryManagement.Book;
import LibraryManagement.Member;

public class LibraryTest {
    public static void main(String[] args) {

        Book b1 = new Book("Java Programming", "James Gosling", "101");
        Member m1 = new Member("Shreya", 1);

        System.out.println("Library Details");
        b1.displayBook();
        m1.displayMember();
    }
}