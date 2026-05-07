package entity.concrete;

import entity.abstracts.Person;
import entity.enums.Status;
import utils.ValidationUtil;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {
    private Set<Book> books = new HashSet<>();
    private MemberRecord memberRecord;

    //constructor
    public Reader(String name, MemberRecord memberRecord) {
        super(name);
        this.setMemberRecord(memberRecord);
    }

    //getter
    public Set<Book> getBooks() {
        return books;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    //setter
    public void setMemberRecord(MemberRecord memberRecord) {
        ValidationUtil.requireNonNull(memberRecord, "`memberRecord` null olamaz.");
        this.memberRecord = memberRecord;
    }

    //methods
    public void borrowBook(Book book) {

        ValidationUtil.requireNonNull(book, "Book null olamaz.");

        if (books.size() >= memberRecord.getMaxBookLimit()) {
            System.out.println("5 Kitaptan fazla alamazsınız.");
            return;
        }

        if (book.getStatus() == Status.BORROWED) {
            System.out.println("Bu kitap zaten ödünç alınmış.");
            return;
        }

        books.add(book);
        book.changeOwner(this);
        book.updateStatus(Status.BORROWED);
        memberRecord.incBookIssued();
        memberRecord.takePay();
        System.out.println(getName() + ", " + book + " ' ı ödünç aldı.");
    }

    public void returnBook(Book book) {
        ValidationUtil.requireNonNull(book, "Book null olamaz.");
        if (!books.contains(book)) {
            System.out.println("Bu kitap " + getName() + " kullanıcısında değil.");
            return;
        }

        books.remove(book);
        book.updateStatus(Status.AVAILABLE);
        book.changeOwner(null);
        memberRecord.decBookIssued();
        System.out.println(getName() + ", " + book + " ' ı iade etti.");
    }

    public void showBook() {
        if (books.isEmpty()) {
            System.out.println(getName() + " ' e ait kiralanan kitap yok.");
            return;
        }

        System.out.println(getName() + " ' a ait kiralanan kitaplar : ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;
        return getName().equals(reader.getName());
    }

    //hashCode
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public void whoYouAre() {
        System.out.println("Reader : " + getName());
    }
}
