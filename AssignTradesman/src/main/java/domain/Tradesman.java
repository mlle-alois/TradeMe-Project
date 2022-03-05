package domain;

import  domain.valueObjects.MemberId;
import  domain.valueObjects.MemberName;

import java.util.List;

public final class Tradesman extends Member {

 private List<Project> projects;

    private Tradesman(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        super(memberId, name, company,subscription);

    }

    public static Tradesman of(MemberId memberId, MemberName name, Company company,Subscription subscription) {
        return new Tradesman(memberId, name, company,subscription);
    }





}
