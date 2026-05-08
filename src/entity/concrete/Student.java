package entity.concrete;

import java.time.LocalDate;

public class Student extends MemberRecord{

    //constructor
    public Student(String type, LocalDate dateOfMembership, String name, String address, String phoneNo) {
        super(type, dateOfMembership, name, address, phoneNo);
    }
}
