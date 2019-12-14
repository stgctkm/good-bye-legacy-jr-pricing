package example.domain.model.specification.basicfare;

import example.domain.model.bill.Amount;
import example.domain.model.specification.Destination;
import example.domain.model.specification.TicketType;
import example.domain.model.specification.discount.RoundTripDiscount;

/**
 * 運賃
 */
public class BasicFare {

    Destination destination;
    TicketType ticketType;

    public BasicFare(Destination destination, TicketType ticketType) {
        this.destination = destination;
        this.ticketType = ticketType;
    }


    public Amount amount() {
        return new RoundTripDiscount(ticketType, destination)
                .discountAmount(destination.basicFare());
    }

}
