package general.user_cases.create_project.application;

import general.kernel.Command;
import general.user_cases.create_project.domain.Company;
import general.user_cases.create_project.domain.MemberName;
import general.user_cases.create_project.domain.Subscription;


public final class ApplyForMembership implements Command {

    public final MemberName name;
    public final Company company;
    public final Subscription subscription;
    public final String PaymentType;

    public ApplyForMembership(MemberName name, Company company, Subscription subscription, String paymentType) {
        this.name = name;
        this.company = company;
        this.subscription = subscription;
        PaymentType = paymentType;
    }
}
