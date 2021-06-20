package com.vikmanik.service;

import com.vikmanik.exception.ParkingLotException;
import com.vikmanik.model.Car;
import com.vikmanik.model.ParkingLot;
import com.vikmanik.model.parking.strategy.ParkingStrategy;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Car car) {
        validateParkingLotExists();
        final Integer nextFreeSlot = parkingStrategy.getNextSlot();
        parkingStrategy.removeSlot(nextFreeSlot);
        parkingLot.park(car, nextFreeSlot);
        return nextFreeSlot;
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new ParkingLotException("Parking lot does not exists to park.");
        }
    }
}
