package summer2020.stuff.utility;

import java.util.Random;

/**
 * This class is a String Utility class. The initial methods for this class will
 * deal with the formation of passwords, but many more string-manipulation methods
 * will be added.
 */
public class StringFormer {

    /* Random object used to generate a random character, number, etc. */
    private static Random rand = new Random();

    public static String generatePassword(String string) {
        return "";
    } // generatePassword

    /**
     * Returns a random character.
     * The random character will be from the following ASCII table values:
     * ASCII Index 33, 35-38, 42, 48-57, 63-90, 97-122
     * @return A random character based on the specified valid characters.
     */
    public static char randomChar() {
        char c = (char) (rand.nextInt(94) + 'a');
        if (c == 34 || c == 39 || c == 40 || c == 41
            || (c > 42 && c < 48) || (c > 57 && c < 63)
            || (c > 90 && c < 97)) {
            return randomChar();
        } else {
            return c;
        } // if
    } // randomChar

    /**
     * Returns a random number.
     *
     * @return A random number.
     */
    public static char randomNumber() {
        return (char) (rand.nextInt(10) + '0');
    } // randomNumber

    /**
     * Returns a special character.
     * The list of special characters that this method may return are:
     * ASCII Index 33, 35-38, 42, 63, 64, and 126
     * @return A random special character based on the specified valid characters.
     */
    public static char randomSpecial() {
        int[] list = new int[] {33, 35, 36, 37, 38, 42, 63, 64, 126};
        return (char) (list[rand.nextInt(9)]);
    } // randomSpecial

    public static char randomUppercase() {
        return '0';
    } // randomUppercase

    public static char randomLowercase() {
        return '0';
    } // randomLowercase
} // StringFormer
