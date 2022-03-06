package general.domain;


import general.domain.valueObjects.MemberId;
import general.domain.valueObjects.MemberName;
import kernel.Entity;

import java.util.Objects;

public class Member implements Entity<MemberId> {
    private final MemberId memberId;
    private final MemberName name;
    private final Company company;
    private final Subscription subscription;

    protected Member(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        this.memberId = Objects.requireNonNull(memberId);
        this.name = Objects.requireNonNull(name);
        this.company = Objects.requireNonNull(company);
        this.subscription = Objects.requireNonNull(subscription);
    }

    public static Member of(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        return new Member(memberId, name, company, subscription);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public MemberName getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }


    @Override
    public MemberId id() {
        return memberId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) && Objects.equals(name, member.name) && Objects.equals(company, member.company) && Objects.equals(subscription, member.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, company, subscription);
    }


    @Override
    public String toString() {
        return "Member id : " + memberId.toString() + " \n" +
                "Name : " + name + " \n" +
                "Company : \n" + company.toString() + " \n";
    }
}
