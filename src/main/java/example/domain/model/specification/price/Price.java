package example.domain.model.specification.price;

import example.domain.model.bill.Amount;

/**
 * 料金
 */
public class Price {
    Amount amount;

    public Price(Amount amount) {
        this.amount = amount;
    }

    public Price multiply(int numberOfPeople) {
        return new Price(amount.multiply(numberOfPeople));
    }

    public Price add(Price other) {
        return new Price(amount.add(other.amount));
    }
}
