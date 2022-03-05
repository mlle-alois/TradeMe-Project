package general.user_cases.apply_for_certificate.domain;

import general.user_cases.apply_for_certificate.application.exception.SubscriptionNotFound;
import general.user_cases.apply_for_certificate.domain.enums.MemberShipType;

import java.util.Objects;

public final class Subscription {

    private final Amount amount;

    private Subscription(String name) {
        if (Objects.equals(name, MemberShipType.annual.getValue())) {
            this.amount = Amount.of(300.0, "$");
            return;
        }

        throw SubscriptionNotFound.WithLog(name);
    }
    
    public static Subscription of(String name) {
        return new Subscription(name);
    }

    public Amount getAmount() {
        return amount;
    }

    public Subscription(Double amount, String currency) {
        this.amount = Amount.of(amount, currency);
    }

}
