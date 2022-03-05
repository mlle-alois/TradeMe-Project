package general.user_cases.apply_for_certificate.domain;

import general.user_cases.apply_for_certificate.domain.valueObjects.MemberId;
import general.user_cases.apply_for_certificate.domain.valueObjects.MemberName;

public final class Contractor extends Member {

    private Contractor(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        super(memberId, name, company, subscription);
    }

    public static Contractor of(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        return new Contractor(memberId, name, company, subscription);
    }
}
