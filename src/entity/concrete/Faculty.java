package entity.concrete;

import java.time.LocalDate;

public class Faculty extends MemberRecord{

    //constructor
    public Faculty(long memberId, String type, LocalDate dateOfMembership, String name, String address, String phoneNo) {
        super(memberId, type, dateOfMembership, name, address, phoneNo);
    }
}
