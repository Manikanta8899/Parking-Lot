package com.vikmanik.commands;
import static com.vikmanik.commands.CommandConstants.CREATE_PARKING_LOT;

import com.vikmanik.exception.InvalidCommandException;
import com.vikmanik.model.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();

    public CommandExecutorFactory() {
        commands.put(CREATE_PARKING_LOT, new CreateParkingLotCommandExecutor());
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (command == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
