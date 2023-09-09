public class CommandUnmark extends Command {
    private static final String INDEX_NOT_INTEGER_ERROR =
            "Command 'unmark' should have a number as an index.";
    private static final String INDEX_INVALID_VALUE_ERROR =
            "A value of index is invalid. Please check the number of tasks.";

    public int index;

    @Override
    public void applyArguments(String args) throws InvalidCommandArgumentException {
        try {
            index = Integer.parseInt(args) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidCommandArgumentException(INDEX_NOT_INTEGER_ERROR);
        }
        if(index < 0 || index >= Nuke.getNumberOfTasks()) {
            throw new InvalidCommandArgumentException(INDEX_INVALID_VALUE_ERROR);
        }
    }

    @Override
    public void run() {
        Nuke.unmarkTask(index);
    }
}