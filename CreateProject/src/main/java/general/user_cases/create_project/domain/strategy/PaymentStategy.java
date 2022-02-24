package general.user_cases.create_project.domain.strategy;

import general.user_cases.create_project.domain.Payment;

public interface PaymentStategy {
    public void pay(Payment payment);
}
