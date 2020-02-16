package bike.simulation;

import java.io.*;
import java.util.logging.Logger;

public class Main {
    private static BufferedReader br;
    private static Bike bike;
    private static final String INVALID_INSTRUCTION_MESSAGE = "Invalid Instruction - Skipping";

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            checkArguments(args);
            bike = new Bike();
            readInput();
        } catch (IOException e) {
            LOGGER.severe(String.valueOf(e));
            System.exit(0);
        }
    }

    private static void checkArguments(String[] args) throws FileNotFoundException {
        int arguments = args.length;

        if(arguments == 0)
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        else if(arguments > 1)
        {
            LOGGER.severe("Please specify only one argument, a filename");
            System.exit(0);
        }
        else
        {
            br = new BufferedReader(new FileReader("File" + File.separator + args[0]));
        }
    }

    private static void readInput() {
        String currentLine = "";
        LOGGER.info("Ready to Receive Input: ");

        while (true) {
            try {
                if (!((currentLine = br.readLine()) != null && !currentLine.equals("/q"))) break;
            } catch (IOException e) {
                LOGGER.severe("IOException encountered\n" + e);
                System.exit(1);
            }

            LOGGER.info(currentLine);
            determineInstruction(currentLine);
        }
    }

    private static void determineInstruction(String instruction) {
        Command command = Command.asCommand(instruction);

        if (command == null) {
            checkForPlaceKeyword(instruction);
            return;
        }

        try {
            checkAndExecuteCommand(command);
        } catch (BikeNotPlacedException e) {
            LOGGER.severe(String.valueOf(e));
        }
    }

    private static void checkAndExecuteCommand(Command command) {
        switch (command) {
            case FORWARD:
                bike.moveForward();
                break;
            case TURN_LEFT:
                bike.turnLeft();
                break;
            case TURN_RIGHT:
                bike.turnRight();
                break;
            case GPS_REPORT:
                bike.reportGPS();
                break;
            default:
                LOGGER.severe("Unsupported Command Detected");
                break;
        }
    }

    private static void checkForPlaceKeyword(String line) {
        try {
            String[] splitLineInTwo = line.split(" ");
            String firstWordInLine = splitLineInTwo[0];
            String secondWordInLine = splitLineInTwo[1];

            if (!Command.PLACE.equals(Command.asCommand(firstWordInLine))) {
                LOGGER.warning(INVALID_INSTRUCTION_MESSAGE);
                return;
            }

            String[] secondHalfOfLineArray = secondWordInLine.split(",");

            if (isSecondHalfOfPlaceStringValid(secondHalfOfLineArray)) {
                Point potentialPosition = new Point(Integer.parseInt(secondHalfOfLineArray[0]), Integer.parseInt(secondHalfOfLineArray[1]));
                bike.placeInGrid(potentialPosition, Direction.valueOf(secondHalfOfLineArray[2]));
            } else {
                LOGGER.warning(INVALID_INSTRUCTION_MESSAGE);
            }

        } catch (IndexOutOfBoundsException e) {
            LOGGER.warning(INVALID_INSTRUCTION_MESSAGE);
        }
    }

    private static boolean isSecondHalfOfPlaceStringValid(String[] secondHalfOfLineArray) {
        return (secondHalfOfLineArray.length == 3) && Direction.asDirection(secondHalfOfLineArray[2]) != null &&
                (Utils.isStringAlsoNumber(secondHalfOfLineArray[0])) && (Utils.isStringAlsoNumber(secondHalfOfLineArray[1]));
    }

}
