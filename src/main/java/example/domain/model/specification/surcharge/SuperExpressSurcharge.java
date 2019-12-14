package example.domain.model.specification.surcharge;

import example.domain.model.bill.Amount;
import example.domain.model.specification.Destination;
import example.domain.model.specification.SeatType;
import example.domain.model.specification.TrainType;

/**
 * 特急料金
 */
public class SuperExpressSurcharge {
    Destination destination;
    TrainType trainType;
    SeatType seatType;

    public SuperExpressSurcharge(Destination destination, TrainType trainType, SeatType seatType) {
        this.destination = destination;
        this.trainType = trainType;
        this.seatType = seatType;
    }

    public Amount amount() {
        Amount superExpressSurCharge = destination.superExpressSurCharge();
        Amount trainSurCharge = trainType.superExpressSurCharge(destination);
        Amount seatSurcharge = seatType.seatSurcharge();
        return superExpressSurCharge.add(trainSurCharge).subtract(seatSurcharge);
    }

}
