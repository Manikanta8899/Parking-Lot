package com.vikmanik.commands;

import com.vikmanik.model.Command;
import com.vikmanik.service.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;

    public CommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}
