package entity.concrete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    //constructor
    public Library(List<Book> books, List<Reader> readers) {
        this.setBooks(books);
        this.setReaders(readers);
    }

    //getter
    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    //setter
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    //toString
    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }

    //fonksiyonlar
    public void newBook(Book book) {
        if(!books.contains(book)) {
            books.add(book);
            System.out.println(book + " isimli kitap kütüphane sistemine eklenmiştir...");
        } else {
            System.out.println(book + " isimli kitap kütüphane sisteminde kayıtlı olduğu için eklenmemiştir...");
        }
    }

    public void lendBook() {

    }

    public void takeBackBook() {

    }

    public void showBook() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
