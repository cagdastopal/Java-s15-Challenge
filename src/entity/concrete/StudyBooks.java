package entity.concrete;

import java.time.LocalDate;

public class StudyBooks extends Book{

    //constructor
    public StudyBooks(Author author, String name, double price, String edition, LocalDate dateOfPurchase) {
        super(author, name, price, edition, dateOfPurchase);
    }
}
