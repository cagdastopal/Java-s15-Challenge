package entity.concrete;

import entity.abstracts.Person;
import entity.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {
    private Set<Book> books = new HashSet<>();
    private static final int MAX_BOOK_LIMIT = 5;

    //constructor
    public Reader(String name) {
        super(name);
    }

    //getter
    public Set<Book> getBooks() {
        return books;
    }

    //fonksiyonlar
    public void borrowBook(Book book) {

        if (books.size() >= MAX_BOOK_LIMIT) {
            System.out.println("5 Kitaptan fazla alamazsınız!");
            return;
        }

        if (book.getStatus() == Status.BORROWED) {
            System.out.println("Bu kitap zaten ödünç alınmış.");
            return;
        }

        books.add(book);
        book.changeOwner(this);
        book.updateStatus(Status.BORROWED);
        System.out.println(getName() + ", " + book + " ' ı ödünç aldı.");
    }

    public void returnBook(Book book) {
        books.remove(book);
        book.updateStatus(Status.AVAILABLE);
        book.changeOwner(null);
        System.out.println(getName() + ", " + book + " ' ı iade etti.");
    }

    public void showBook() {
        if (books.isEmpty()) {
            System.out.println(getName() + " ' e ait kiralanan kitap yok!");
            return;
        }

        System.out.println(getName() + " ' a ait kiralanan kitaplar : ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Reader : " + getName());
    }
}
