package bike.simulation;

public final class Utils {

    protected static boolean isStringAlsoNumber(String potentialNumber) {
        return potentialNumber.matches("-?(0|[1-9]\\d*)");
    }
}
