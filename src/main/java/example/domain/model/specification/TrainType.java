package example.domain.model.specification;

import example.domain.model.bill.Amount;

/**
 * 列車種類
 */
public enum TrainType {
    のぞみ,
    ひかり;

    public Amount superExpressSurCharge(Destination destination) {
        if (this == ひかり) return new Amount(0);
        return destination.trainSurcharge();
    }
}
