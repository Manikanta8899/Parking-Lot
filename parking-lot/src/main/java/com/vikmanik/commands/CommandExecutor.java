package com.vikmanik.commands;

public interface CommandExecutor {
    public boolean validate(Command command);
    public void execute(Command command);
}
