package entity.concrete;

import java.time.LocalDate;

public class Journals extends Book {

    //constructor
    public Journals(long bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}
