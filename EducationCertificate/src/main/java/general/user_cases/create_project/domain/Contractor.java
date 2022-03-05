package general.user_cases.create_project.domain;

import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.MemberName;

public final class Contractor extends Member {

    private Contractor(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        super(memberId, name, company, subscription);
    }

    public static Contractor of(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        return new Contractor(memberId, name, company, subscription);
    }
}
