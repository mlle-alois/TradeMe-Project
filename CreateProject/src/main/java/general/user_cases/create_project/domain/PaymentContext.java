package general.user_cases.create_project.domain;

import general.user_cases.create_project.application.NoSuchPaymentType;

import java.util.Objects;

public class PaymentContext {

    private PaymentStategy paymentStategy;

    public PaymentContext(String paymentStategy) {
        if(Objects.equals(paymentStategy, PaymentContextType.masterCard.getValue())) {
            this.paymentStategy = new PaymentMasterCard();
            return;
        }
        throw NoSuchPaymentType.WithLog(paymentStategy);
    }

    public void setPaymentStategy(PaymentStategy paymentStategy) {
        this.paymentStategy = paymentStategy;
    }

    public void pay(Payment payment){
        this.paymentStategy.pay(payment);
    }
}
