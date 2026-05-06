package entity.concrete;

import entity.enums.Status;
import utils.ValidationUtil;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book>{
    private long bookId;
    private String author;
    private String name;
    private double price;
    private Status status;
    private String edition;
    private LocalDate dateOfPurchase;
    private Reader reader;

    //constructor
    public Book(long bookId, String author, String name, double price, String edition, LocalDate dateOfPurchase) {
        this.setBookId(bookId);
        this.setAuthor(author);
        this.setName(name);
        this.setPrice(price);
        this.setEdition(edition);
        this.setDateOfPurchase(dateOfPurchase);
        this.status = Status.AVAILABLE;
        this.reader = null;
    }

    //getter
    public long getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Reader getReader() {
        return reader;
    }

    //setter
    private void setBookId(long bookId) {
        ValidationUtil.requireNonNull(bookId, "`bookId` null olamaz...");
        ValidationUtil.requirePositive(bookId, "`bookId` 0 veya daha düşük olamaz...");
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        ValidationUtil.requireNonNull(author, "`author` null olamaz...");
        ValidationUtil.requireNonEmpty(author, "`author` boş olamaz...");
        this.author = author;
    }

    public void setName(String name) {
        ValidationUtil.requireNonNull(name, "`name` null olamaz...");
        ValidationUtil.requireNonEmpty(name, "`name` boş olamaz...");
        this.name = name;
    }

    public void setPrice(double price) {
        ValidationUtil.requireNonNull(price, "`price` null olamaz...");
        ValidationUtil.requirePositive(price, "`price` 0 veya daha düşük olamaz...");
        this.price = price;
    }

    public void setStatus(Status status) {
        ValidationUtil.requireNonNull(status, "`status` null olamaz...");
        this.status = status;
    }

    public void setEdition(String edition) {
        ValidationUtil.requireNonNull(edition, "`edition` null olamaz...");
        ValidationUtil.requireNonEmpty(edition, "`edition` boş olamaz...");
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        ValidationUtil.requireNonNull(dateOfPurchase, "`dateOfPurchase` null olamaz...");
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setReader(Reader reader) {
        ValidationUtil.requireNonNull(reader, "`reader` null olamaz...");
        this.reader = reader;
    }

    public void changeOwner(Reader reader) {
      this.setReader(reader);
    }

    public void display() {
        System.out.println(toString());
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    //toString
    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", reader=" + (reader == null ? "Yok" : reader.getName()) +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    //compareTo
    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }
}
