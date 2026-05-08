package entity.concrete;

import entity.abstracts.Person;
import utils.ValidationUtil;

import java.util.ArrayList;
import java.util.List;


public class Author extends Person {
    private List<Book> books = new ArrayList<>();

    //constructor
    public Author(String name) {
        super(name);
    }

    //getter
    public List<Book> getBooks() {
        return books;
    }

    //setter
    public void setBooks(List<Book> books) {
        ValidationUtil.requireNonNull(books, "`books` null olamaz.");
        this.books = books;
    }

    //methods
    public void newBook(Book book) {
        if(!books.contains(book)) {
            books.add(book);
            System.out.println("Autor " + getName() + " ' a ait yeni kitap eklenmiştir : " + book);
        } else {
            System.out.println(book + " zaten ekli.");
        }
    }

    public void showBook() {
        if(books.isEmpty()) {
            System.out.println(getName() + " ' e ait eklenmiş bir kitap yok.");
            return;
        }

        System.out.println("Autor " + getName() + " ' a ait kitaplar : ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Author : " + getName());
    }
}
