package entity.concrete;

import java.time.LocalDate;

public class Faculty extends MemberRecord{

    //constructor
    public Faculty(String type, LocalDate dateOfMembership, String name, String address, String phoneNo) {
        super(type, dateOfMembership, name, address, phoneNo);
    }
}
