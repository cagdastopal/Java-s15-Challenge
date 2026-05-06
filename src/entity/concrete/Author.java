package entity.concrete;

import entity.abstracts.Person;

import java.util.HashSet;
import java.util.Set;


public class Author extends Person {
    private Set<Book> books = new HashSet<>();

    //constructor
    public Author(String name) {
        super(name);
    }

    //getter
    public Set<Book> getBooks() {
        return books;
    }

    //fonksiyonlar
    public void newBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        if(books.isEmpty()) {
            System.out.println(getName() + " ' e ait eklenmiş bir kitap yok...");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("Author : " + getName());
    }
}
