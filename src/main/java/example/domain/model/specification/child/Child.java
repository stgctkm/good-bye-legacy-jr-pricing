package example.domain.model.specification.child;

import example.domain.model.bill.Amount;
import example.domain.model.specification.basicfare.BasicFare;
import example.domain.model.specification.price.Price;
import example.domain.model.specification.surcharge.SuperExpressSurcharge;

/**
 * 子供料金
 */
public class Child {
    BasicFare basicFare;
    SuperExpressSurcharge superExpressSurcharge;

    public Child(BasicFare basicFare, SuperExpressSurcharge superExpressSurcharge) {
        this.basicFare = basicFare;
        this.superExpressSurcharge = superExpressSurcharge;
    }

    public Price amount() {
        Amount amount = basicFare.amount().divide(2);
        Amount childBasicFare = amount.roundFloor();
        Amount childSurcharge = superExpressSurcharge.amount().divide(2).roundFloor();
        return new Price(childBasicFare.add(childSurcharge));
    }

    public Price multiply(int child) {
        return amount().multiply(child);
    }
}
