package com.vikmanik;

import com.vikmanik.exception.InvalidCommandException;
import com.vikmanik.model.Command;
import com.vikmanik.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        commands.put(CommandConstants.CREATE_PARKING_LOT, new CreateParkingLotCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (command == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
