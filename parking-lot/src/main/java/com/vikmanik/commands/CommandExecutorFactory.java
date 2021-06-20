package com.vikmanik.commands;

import com.vikmanik.exception.InvalidCommandException;
import com.vikmanik.model.Command;
import com.vikmanik.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME, new CreateParkingLotCommandExecutor(parkingLotService));
        commands.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (command == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
