package com.vikmanik.commands;

import com.vikmanik.model.Car;
import com.vikmanik.model.Command;
import com.vikmanik.service.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "park";
    public ParkCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(final Command command) {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        parkingLotService.park(car);
    }
}