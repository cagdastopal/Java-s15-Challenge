package entity.concrete;

import utils.ValidationUtil;

import java.time.LocalDate;
import java.util.Objects;

public class MemberRecord {
    private long memberId;
    private String type;
    private LocalDate dateOfMembership;
    private String name;
    private String address;
    private String phoneNo;


    private int NO_BOOKS_ISSUED = 0 ;
    private double AMOUNT = 0.0;
    private static final int MAX_BOOK_LIMIT = 5;

    //constructor
    public MemberRecord(long memberId, String type, LocalDate dateOfMembership, String name,
                        String address, String phoneNo) {
        this.setMemberId(memberId);
        this.setType(type);
        this.setDateOfMembership(dateOfMembership);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNo(phoneNo);
    }

    //getter
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

    //setter
    private void setMemberId(long memberId) {
        ValidationUtil.requireNonNull(memberId, "`memberId` null olamaz...");
        ValidationUtil.requirePositive(memberId, "`memberId` 0 veya daha düşük olamaz...");
        this.memberId = memberId;
    }

    public void setType(String type) {
        ValidationUtil.requireNonNull(type, "`type` null olamaz...");
        ValidationUtil.requireNonEmpty(type, "`type` boş olamaz...");
        this.type = type;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        ValidationUtil.requireNonNull(dateOfMembership, "`dateOfMembership` null olamaz...");
        this.dateOfMembership = dateOfMembership;
    }

    public void setName(String name) {
        ValidationUtil.requireNonNull(name, "`name` null olamaz...");
        ValidationUtil.requireNonEmpty(name, "`name` boş olamaz...");
        this.name = name;
    }

    public void setAddress(String address) {
        ValidationUtil.requireNonNull(address, "`address` null olamaz...");
        ValidationUtil.requireNonEmpty(address, "`address` boş olamaz...");
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        ValidationUtil.requireNonNull(phoneNo, "`phoneNo` null olamaz...");
        ValidationUtil.requireNonEmpty(phoneNo, "`phoneNo` boş olamaz...");
        this.phoneNo = phoneNo;
    }

    //toString
    @Override
    public String toString() {
        return "MemberRecord{" +
                "memberId=" + memberId +
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberRecord memberrecord = (MemberRecord) o;
        return Objects.equals(memberId, memberrecord.memberId);
    }

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }

    //fonksiyonlar
    public long getMember() {
        return memberId;
    }

    public void incBookIssued() {
        if(NO_BOOKS_ISSUED >= 0 && NO_BOOKS_ISSUED < MAX_BOOK_LIMIT) {
            NO_BOOKS_ISSUED += 1;
        } else {
            System.out.println(memberId + " aynı anda kitap kiralama limitine ulaşmıştır, kitap bırakmadan yeni kitap kiralayamaz...");
        }
    }

    public void decBookIssued() {
        if(NO_BOOKS_ISSUED > 0 && NO_BOOKS_ISSUED <= MAX_BOOK_LIMIT) {
            NO_BOOKS_ISSUED -= 1;
        }
    }

    public void payBill(double pay) {
        AMOUNT += pay;
        System.out.println(memberId + " id ' li" + name + " üye " + AMOUNT + " TL ödeme yaptı.");
    }
}
