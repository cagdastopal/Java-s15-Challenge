package entity.concrete;

import java.time.LocalDate;

public class StudyBooks extends Book{

    //constructor
    public StudyBooks(long bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}
