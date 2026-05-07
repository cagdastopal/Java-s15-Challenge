package entity.concrete;

import entity.abstracts.Person;
import utils.ValidationUtil;

public class Librarian extends Person {

    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        ValidationUtil.requireNonNull(password, "`password` null olamaz.");
        ValidationUtil.requireNonEmpty(password, "`password` boş olamaz.");
        this.password = password;
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
    }

    public void addReader(Library library, Reader reader) {
        library.addReader(reader);
    }

    public void lendBook(Library library, Reader reader, Book book) {
        library.lendBook(reader, book);
    }

    public void takeBackBook(Library library, Reader reader, Book book) {
        library.takeBackBook(reader, book);
    }

    public void searchBook(Library library, String bookName) {
        library.searchBook(bookName);
    }

    public void showBooks(Library library) {
        library.showBook();
    }

    @Override
    public void whoYouAre() {
        System.out.println("Librarian : " + getName());
    }
}