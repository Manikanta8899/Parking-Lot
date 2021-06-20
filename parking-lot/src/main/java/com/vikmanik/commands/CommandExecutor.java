package com.vikmanik.commands;

import com.vikmanik.OutputPrinter;
import com.vikmanik.model.Command;
import com.vikmanik.service.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }
    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}
