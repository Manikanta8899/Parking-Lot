package com.vikmanik.commands;

import com.vikmanik.OutputPrinter;
import com.vikmanik.model.Command;
import com.vikmanik.model.Slot;
import com.vikmanik.service.ParkingLotService;
import java.util.List;
import java.util.stream.Collectors;

public class ColorToSlotNumberCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "slot_numbers_for_cars_with_colour";

    public ColorToSlotNumberCommandExecutor(
            final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(final Command command) {
        final List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));
        if (slotsForColor.isEmpty()) {
            outputPrinter.notFound();
        } else {
            final String result =
                    slotsForColor.stream()
                            .map(slot -> slot.getSlotNumber().toString())
                            .collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }
    }
}