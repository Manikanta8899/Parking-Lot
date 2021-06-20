package com.vikmanik.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vikmanik.exception.ParkingLotException;
import com.vikmanik.model.Car;
import com.vikmanik.model.ParkingLot;
import com.vikmanik.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.vikmanik.model.parking.strategy.ParkingStrategy;
import org.junit.Test;

public class ParkingLotServiceTest {
    private ParkingLotService parkingLotService = new ParkingLotService();
    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot;

    @Test(expected = ParkingLotException.class)
    public void testCreatingParkingLotWhenAlreadyExists() {
        final ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot(new ParkingLot(10), new NaturalOrderingParkingStrategy());
        parkingLotService.createParkingLot(new ParkingLot(20), new NaturalOrderingParkingStrategy());
    }

    @Test
    public void testSlotNumberIsRemovedFromStrategyAfterParking() {
        final Car testCar = new Car("test-car-no", "white");
        when(parkingStrategy.getNextSlot()).thenReturn(1);
        parkingLotService.park(testCar);
        verify(parkingStrategy).removeSlot(1);
    }

    @Test
    public void testParkingIsDoneInTheParkingLot() {
        final Car testCar = new Car("test-car-no", "white");
        when(parkingStrategy.getNextSlot()).thenReturn(1);
        parkingLotService.park(testCar);
        verify(parkingLot).park(testCar, 1);
    }

    @Test(expected = ParkingLotException.class)
    public void testParkingCarWithoutCreatingParkingLot() {
        final ParkingLotService parkingLotService = new ParkingLotService();
        final Car testCar = new Car("test-car-no", "white");
        parkingLotService.park(testCar);
    }
}
