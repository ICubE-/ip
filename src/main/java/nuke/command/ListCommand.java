package nuke.command;

import nuke.command.exception.InvalidCommandArgumentException;
import nuke.Nuke;

public class ListCommand extends Command {
    public static final String TYPE = "list";
    private static final String USAGE = TYPE;

    @Override
    public void applyArguments(String args) throws InvalidCommandArgumentException {
        if (!args.isEmpty()) {
            throwArgumentException(ERROR_MSG_TOO_MANY_ARGS);
        }
    }

    @Override
    protected String getType() {
        return TYPE;
    }

    @Override
    protected String getUsage() {
        return USAGE;
    }

    @Override
    public void run(Nuke nuke) {
        nuke.listTask();
    }

    private static final String ERROR_MSG_TOO_MANY_ARGS =
            "Command 'list' should have no arguments.";
}