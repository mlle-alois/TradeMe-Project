package general.user_cases.create_project.domain;

import general.user_cases.create_project.application.NegativeAmount;
import general.user_cases.create_project.application.NoCurrencyForAmount;

public final class Amount {
    private double amount;
    private String currency;

    public Amount(double amount, String currency) {
        if(amount<0){
            throw NegativeAmount.WithLog(amount);
        }
        if(currency.equals("")){
            throw NoCurrencyForAmount.WithLog(amount);
        }

        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

}
