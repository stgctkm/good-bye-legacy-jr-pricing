package example.domain.model.specification.adult;

import example.domain.model.specification.basicfare.BasicFare;
import example.domain.model.specification.price.Price;
import example.domain.model.specification.surcharge.SuperExpressSurcharge;

/**
 * 大人料金
 */
public class Adult {

    BasicFare basicFare;
    SuperExpressSurcharge superExpressSurcharge;

    public Adult(BasicFare basicFare, SuperExpressSurcharge superExpressSurcharge) {
        this.basicFare = basicFare;
        this.superExpressSurcharge = superExpressSurcharge;
    }

    public Price amount() {
        return new Price(basicFare.amount().add(superExpressSurcharge.amount()));
    }

    public Price multiply(int adult) {
        return amount().multiply(adult);
    }
}
