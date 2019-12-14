package example.domain.model.specification;

import example.domain.model.bill.Amount;

/**
 * 座席区分
 */
public enum SeatType {
    指定席,
    自由席;

    public Amount seatSurcharge() {
        if (this == 指定席) return new Amount(0);
        return new Amount(530);
    }
}
