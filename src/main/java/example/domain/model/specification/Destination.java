package example.domain.model.specification;

import example.domain.model.bill.Amount;

/**
 * 目的地
 */
public enum Destination {
    新大阪(new Amount(8910), new Amount(5490), new Amount(320), 553),
    姫路(new Amount(10010), new Amount(5920), new Amount(530) , 644);

    Amount basicFare;
    Amount superExpressSurCharge;
    Amount trainSurcharge;
    int distance;

    Destination(Amount basicFare, Amount superExpressSurCharge, Amount trainSurcharge, int distance) {
        this.basicFare = basicFare;
        this.superExpressSurCharge = superExpressSurCharge;
        this.trainSurcharge = trainSurcharge;
        this.distance = distance;
    }

    public Amount basicFare() {
        return basicFare;
    }

    public Amount superExpressSurCharge() {
        return superExpressSurCharge;
    }

    public Amount trainSurcharge() {
        return trainSurcharge;
    }

    public boolean isRoundTripDiscountTarget() {
        return  distance >= 601;
    }
}
