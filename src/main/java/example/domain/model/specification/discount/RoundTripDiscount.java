package example.domain.model.specification.discount;

import example.domain.model.bill.Amount;
import example.domain.model.specification.Destination;
import example.domain.model.specification.TicketType;

public class RoundTripDiscount {
    TicketType ticketType;
    Destination destination;

    public RoundTripDiscount(TicketType ticketType, Destination destination) {
        this.ticketType = ticketType;
        this.destination = destination;
    }

    public Amount discountAmount(Amount basicFare) {
        if (ticketType.is片道()) return basicFare;
        if (!destination.isRoundTripDiscountTarget())
            return basicFare;

        return basicFare.multiply(0.9).roundFloor();
    }
}
