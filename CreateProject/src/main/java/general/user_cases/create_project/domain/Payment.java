package general.user_cases.create_project.domain;

import general.kernel.Entity;
import general.user_cases.create_project.domain.valueObjects.PaymentId;

public final class Payment implements Entity<PaymentId> {
    private final PaymentId paymentId;
    private final Amount amount;
    private final Member member;

    private Payment(PaymentId paymentId, Amount amount, Member member) {
        this.amount = amount;
        this.member = member;
        this.paymentId = paymentId;
    }
    
    public static Payment of(PaymentId paymentId, Amount amount, Member member) {
        return new Payment(paymentId, amount, member);
    }

    public Amount getAmount() {
        return amount;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public PaymentId id() {
        return paymentId;
    }
}
