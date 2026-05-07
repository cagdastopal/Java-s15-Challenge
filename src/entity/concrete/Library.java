package entity.concrete;

import utils.ValidationUtil;

import java.util.ArrayList;
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
        ValidationUtil.requireNonNull(books, "`books` null olamaz.");
        this.books = books;
    }

    public void setReaders(List<Reader> readers) {
        ValidationUtil.requireNonNull(readers, "`readers` null olamaz.");
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

    //methods
    protected boolean verifyMember(Reader reader) {
        if (readers.contains(reader)) {
            return true;
        } else {
            return false;
        }
    }

    protected void addReader(Reader reader) {
        if(!readers.contains(reader)) {
            readers.add(reader);
            System.out.println(reader.getName() + " kütüphane sistemine eklenmiştir.");
        } else {
            System.out.println(reader.getName() + " kütüphane sisteminde kayıtlı olduğu için eklenmemiştir.");
        }
    }

    protected void addBook(Book book) {
        if(!books.contains(book)) {
            books.add(book);
            System.out.println(book + " isimli kitap kütüphane sistemine eklenmiştir.");
        } else {
            System.out.println(book + " isimli kitap kütüphane sisteminde kayıtlı olduğu için eklenmemiştir.");
        }
    }

    protected void removeBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
            System.out.println(book + " isimli kitap kütüphane sisteminden kaldırılmıştır.");
        } else {
            System.out.println(book + " isimli kitap kütüphane sisteminde bulunamadı.");
        }
    }

    protected void lendBook(Reader reader, Book book) {
        if (!verifyMember(reader)) {
            System.out.println("Kayıtlı olmayan kullanıcı kitap alamaz.");
            return;
        }

        if (!books.contains(book)) {
            System.out.println("Bu kitap kütüphane sisteminde yok.");
            return;
        }

        reader.borrowBook(book);
    }

    protected void takeBackBook(Reader reader, Book book) {
        if (!verifyMember(reader)) {
            System.out.println("Kayıtlı olmayan kullanıcı kitap iade edemez.");
            return;
        }

        if (!books.contains(book)) {
            System.out.println("Bu kitap kütüphane sisteminde yok.");
            return;
        }

        reader.returnBook(book);
    }

    protected void showBook() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    protected void searchBook(String bookName) {
        boolean found = false;

        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Bu kitap kütüphane sisteminde yok.");
        }
    }
}