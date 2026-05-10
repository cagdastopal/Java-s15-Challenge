package entity.concrete;

import utils.ValidationUtil;

import java.time.LocalDate;
import java.util.Objects;

public class MemberRecord {
    private static long id = 1;

    private long memberId;
    private String type;
    private LocalDate dateOfMembership;
    private String name;
    private String address;
    private String phoneNo;

    private int noBooksIssued = 0;
    private double amount = 0.0;

    private final int MAX_BOOK_LIMIT = 5;

    public MemberRecord(String type, LocalDate dateOfMembership, String name,
                        String address, String phoneNo) {
        this.memberId = id++;
        this.setType(type);
        this.setDateOfMembership(dateOfMembership);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNo(phoneNo);
    }

    public long getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public double getAmount() {
        return amount;
    }

    public int getMaxBookLimit() {
        return MAX_BOOK_LIMIT;
    }

    public void setType(String type) {
        ValidationUtil.requireNonNull(type, "`type` null olamaz.");
        ValidationUtil.requireNonEmpty(type, "`type` boş olamaz.");
        this.type = type;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        ValidationUtil.requireNonNull(dateOfMembership, "`dateOfMembership` null olamaz.");
        this.dateOfMembership = dateOfMembership;
    }

    public void setName(String name) {
        ValidationUtil.requireNonNull(name, "`name` null olamaz.");
        ValidationUtil.requireNonEmpty(name, "`name` boş olamaz.");
        this.name = name;
    }

    public void setAddress(String address) {
        ValidationUtil.requireNonNull(address, "`address` null olamaz.");
        ValidationUtil.requireNonEmpty(address, "`address` boş olamaz.");
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        ValidationUtil.requireNonNull(phoneNo, "`phoneNo` null olamaz.");
        ValidationUtil.requireNonEmpty(phoneNo, "`phoneNo` boş olamaz.");
        this.phoneNo = phoneNo;
    }

    public void incBookIssued() {
        if (noBooksIssued < MAX_BOOK_LIMIT) {
            noBooksIssued++;
        } else {
            System.out.println(memberId + " id'li " + name + " kitap kiralama limitine ulaşmıştır.");
        }
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }

    public void takePay(Book book) {
        ValidationUtil.requireNonNull(book, "`book` null olamaz.");

        amount += book.getPrice();

        System.out.println(name + " adlı üye " + book.getPrice() + " TL ödeme yaptı.");
        System.out.println("Toplam ödeme: " + amount + " TL");
    }

    public void getPay(Book book) {
        ValidationUtil.requireNonNull(book, "`book` null olamaz.");

        amount -= book.getPrice()/2;

        System.out.println(name + " adlı üye " + book.getPrice() / 2 + " TL ödeme aldı.");
        System.out.println(name + " adlı üyenin toplam ödemesi : " + amount + " TL");
    }

    public long getMember() {
        return memberId;
    }

    @Override
    public String toString() {
        return "MemberRecord{" +
                "memberId=" + memberId +
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", noBooksIssued=" + noBooksIssued +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberRecord that = (MemberRecord) o;
        return memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}