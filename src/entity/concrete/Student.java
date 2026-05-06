package entity.concrete;

import java.time.LocalDate;

public class Student extends MemberRecord{

    //constructor
    public Student(long memberId, String type, LocalDate dateOfMembership, String name, String address, String phoneNo) {
        super(memberId, type, dateOfMembership, name, address, phoneNo);
    }
}
