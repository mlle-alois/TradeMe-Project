package general.user_cases.create_project.domain;

import general.user_cases.create_project.application.exception.NoSuchPaymentType;
import general.user_cases.create_project.domain.enums.PaymentContextType;
import general.user_cases.create_project.domain.strategy.PaymentStategy;

import java.util.Objects;

public final class PaymentContext {

    private PaymentStategy paymentStategy;

    private PaymentContext(String paymentStrategy) {
        if (Objects.equals(paymentStrategy, PaymentContextType.masterCard.getValue())) {
            this.paymentStategy = new PaymentMasterCard();
            return;
        }
        throw NoSuchPaymentType.WithLog(paymentStrategy);
    }
    
    public static PaymentContext of(String paymentStrategy) {
        return new PaymentContext(paymentStrategy);
    }

    public void setPaymentStategy(PaymentStategy paymentStategy) {
        this.paymentStategy = paymentStategy;
    }

    public void pay(Payment payment) {
        this.paymentStategy.pay(payment);
    }
}
