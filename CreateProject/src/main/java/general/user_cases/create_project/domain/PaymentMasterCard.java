package general.user_cases.create_project.domain;

import general.user_cases.create_project.domain.strategy.PaymentStategy;

public final class PaymentMasterCard implements PaymentStategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Membre " + payment.getMember().id().getValue() + " payment avec master card");
        // On peut rajouter ici une exception personnalisée si le payment rate
    }
}
