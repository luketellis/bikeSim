package bike.simulation;

import java.io.*;
import java.util.logging.Logger;

public class Main {
    private static BufferedReader br;
    private static Bike bike;

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            checkArguments(args);
            bike = new Bike();
            readInput();
        } catch (FileNotFoundException e) {
           LOGGER.severe("File Not Found, Exiting");
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
            br = new BufferedReader(new FileReader(args[0]));
        }
    }

    private static void readInput() {
        String currentLine = "";


        while (true) {
            LOGGER.info("Ready to Receive Input: ");
            try {
                if (!((currentLine = br.readLine()) != null && !currentLine.equals("/q"))) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            LOGGER.info(currentLine);
            determineInstruction(currentLine);
        }
    }

    private static void determineInstruction(String instruction)
    {
        //1. PLACE <X>,<Y>,<Facing-direction>
        try {
        Command command = Command.valueOf(instruction);

        switch (command) {
            case FORWARD :
                bike.moveForward();
                break;
            case TURN_LEFT :
                bike.turnLeft();
                break;
            case TURN_RIGHT :
                bike.turnRight();
                break;
            case GPS_REPORT :
                bike.reportGPS();
                break;
            default:
                break;
        }
        } catch (IllegalArgumentException e) {
            checkForPlaceKeyword(instruction);
        }
    }

    private static void checkForPlaceKeyword(String line) {
        try {
            String[] splitInTwo = line.split(" ");

            String[] splitInThree = splitInTwo[1].split(",");

            if (splitInTwo[0].equals("PLACE") && splitInThree.length == 3
                    && splitInThree[2].matches("NORTH|SOUTH|EAST|WEST")) {
                Point startingPoint = new Point(Integer.parseInt(splitInThree[0]), Integer.parseInt(splitInThree[1]));
                bike.place(startingPoint, Direction.valueOf(splitInThree[2]));
            } else {
                LOGGER.warning("Invalid Instruction - Skipping");
            }

        }catch(IndexOutOfBoundsException e)
        {
            LOGGER.warning("Invalid Instruction - Skipping");
        }
    }
}
