package entity.concrete;

import java.time.LocalDate;

public class Magazines extends Book{

    //constructor
    public Magazines(long bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}
