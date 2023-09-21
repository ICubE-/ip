package nuke.task;

/**
 * Represents an event that has the start and the end.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Constructs an event with the name, the start period, and the end period.
     *
     * @param name name of the task.
     * @param from start period of the task.
     * @param to end period of the task.
     */
    public Event(String name, String from, String to) {
        super(name);
        setFrom(from);
        setTo(to);
    }

    /**
     * Returns start period of the event.
     *
     * @return start period of the event
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets start period of the event.
     *
     * @param from start period of the event
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Returns end period of the event.
     *
     * @return end period of the event
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets end period of the event.
     *
     * @param to end period of the event
     */
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return String.format("%s (from: %s to: %s)",
                super.toString(), getFrom(), getTo());
    }

    @Override
    public String formatData() {
        return String.format("%s / %s / %s", super.formatData(), getFrom(), getTo());
    }

    public static final String TYPE = "E";
}
