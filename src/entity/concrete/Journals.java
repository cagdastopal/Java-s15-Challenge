package entity.concrete;

import java.time.LocalDate;

public class Journals extends Book {

    //constructor
    public Journals(Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(author, name, price, edition, dateOfPurchase);
    }
}
