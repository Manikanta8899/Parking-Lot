package com.vikmanik.service;

import com.vikmanik.exception.ParkingLotException;
import com.vikmanik.model.ParkingLot;
import com.vikmanik.model.parking.strategy.ParkingStrategy;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(final int capacity, final ParkingStrategy parkingStrategy) {
        if (parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= capacity; i++) {
            parkingStrategy.addSlot(i);
        }
    }
}
