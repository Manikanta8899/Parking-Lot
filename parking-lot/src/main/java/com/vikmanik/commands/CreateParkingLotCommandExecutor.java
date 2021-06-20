package com.vikmanik.commands;

import com.vikmanik.commands.CommandExecutor;
import com.vikmanik.model.Command;
import com.vikmanik.model.ParkingLot;
import com.vikmanik.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.vikmanik.service.ParkingLotService;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";
    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    public boolean validate(final Command command) {
            final List<String> params = command.getParams();
            if (params.size() != 1) {
                return false;
            }

            try {
                Integer.parseInt(params.get(0));
                return true;
            } catch (NumberFormatException exception) {
                return false;
            }
        }

        @Override
        public void execute(final Command command) {
            final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
            parkingLotService.createParkingLot(new ParkingLot(parkingLotCapacity), new NaturalOrderingParkingStrategy());
        }
}
