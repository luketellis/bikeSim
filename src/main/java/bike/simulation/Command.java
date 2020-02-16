package bike.simulation;

public enum Command {
    PLACE,
    FORWARD,
    TURN_LEFT,
    TURN_RIGHT,
    GPS_REPORT;

    public static Command asCommand(String input) {
        for (Command command : Command.values()) {
            if (command.name().equalsIgnoreCase(input))
                return command;
        }
        return null;
    }
}