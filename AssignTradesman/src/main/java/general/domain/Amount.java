package general.domain;


import general.application.exception.NegativeAmount;
import general.application.exception.NoCurrencyForAmount;

public final class Amount {
    private final double amount;
    private final String currency;

    private Amount(double amount, String currency) {
        if (amount < 0) {
            throw NegativeAmount.WithLog(amount);
        }
        if (currency.equals("")) {
            throw NoCurrencyForAmount.WithLog(amount);
        }

        this.amount = amount;
        this.currency = currency;
    }
    
    public static Amount of(double amount, String currency) {
        return new Amount(amount, currency);
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
