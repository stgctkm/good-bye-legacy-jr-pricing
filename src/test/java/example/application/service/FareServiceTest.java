package example.application.service;

import example.domain.model.specification.TicketType;
import example.domain.model.specification.basicfare.BasicFare;
import example.domain.model.specification.child.Child;
import example.domain.model.specification.discount.RoundTripDiscount;
import example.domain.model.specification.adult.Adult;
import example.domain.model.specification.surcharge.SuperExpressSurcharge;
import example.domain.model.attempt.Attempt;
import example.domain.model.bill.Amount;
import example.domain.model.rules.DistanceTable;
import example.domain.model.rules.FareTable;
import example.domain.model.rules.SurchargeTable;
import example.domain.model.specification.Destination;
import example.domain.model.specification.SeatType;
import example.domain.model.specification.TrainType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FareServiceTest {

    static private FareService fareService;

    static private FareTable fareTable;
    static private SurchargeTable surchargeTable;
    static private DistanceTable distanceTable;

    @BeforeAll
    static void setUp() {
        fareTable = new FareTable();
        surchargeTable = new SurchargeTable();
        distanceTable = new DistanceTable();

        fareService = new FareService(fareTable, surchargeTable, distanceTable);
    }

    @Test
    void 基本() {
        Attempt attempt = AttemptFactory.大人1_通常期_新大阪_指定席_ひかり_片道();
        Amount result = fareService.amountFor(attempt);
        Destination destination = Destination.新大阪;
        Amount expected = new Amount(fareTable.fare(destination) + surchargeTable.surcharge(destination));
        assertEquals(expected, result);
    }

    @Test
    void 基本料金() {
        assertEquals(new Amount(8910), new BasicFare(Destination.新大阪).amount());
    }

    @Test
    void 特急料金() {
        assertEquals(new Amount(5490 + 320),
                new SuperExpressSurcharge(Destination.新大阪, TrainType.のぞみ, SeatType.指定席).amount());
    }

    @Test
    void 料金() {
        assertEquals(
                new Amount(8910 + 5490 + 320), //14720
                new Adult(
                        new BasicFare(Destination.新大阪),
                        new SuperExpressSurcharge(Destination.新大阪, TrainType.のぞみ, SeatType.指定席)
                ).amount()

        );
    }

    @Test
    void 子供料金() {
        assertEquals(
                new Amount(7190),
                new Child(
                        new BasicFare(Destination.新大阪),
                        new SuperExpressSurcharge(Destination.新大阪, TrainType.ひかり, SeatType.指定席)
                ).amount()
        );
    }

    @Test
    void 往復割引() {
        assertEquals(
                new Amount(9000),
                new RoundTripDiscount(
                        TicketType.往復,
                        Destination.姫路
                ).discountAmount(new BasicFare(Destination.姫路))
        );
    }
}