package summer2020.stuff.utility;

import java.util.LinkedList;
import java.util.Random;

/**
 * This class is a String Utility class. The initial methods for this class will
 * deal with the formation of passwords, but many more string-manipulation methods
 * will be added.
 */
public class StringFormer {

    /* Random object used to generate a random character, number, etc. */
    private static Random rand = new Random();

    /**
     * Generates a password based off of the specified requirements for the password and the custom
     * string.
     * @param str the initial string used to generate the password.
     * @param needSpecial determines if the password requires a special character.
     * @param needUppercase determines if the password requires an uppercase character.
     * @param needLowercase determines if the password requires a lowercase character.
     * @param needNumber determines if the password requires a number.
     * @return A string representing a password based on the requirements.
     */
    public static String generatePassword(String str, boolean needSpecial,
                                          boolean needUppercase, boolean needLowercase,
                                          boolean needNumber) {
        LinkedList<String> pass = new LinkedList<>();
        LinkedList<Integer> options = new LinkedList<>();
        pass.add(str);
        if (needSpecial) {
            options.add(1);
        } // if
        if (needUppercase) {
            options.add(2);
        } // if
        if (needLowercase) {
            options.add(3);
        } // if
        if (needNumber) {
            options.add(4);
        } // if
        do {
            if (options.size() <= 0) {
                pass.add(rand.nextInt(pass.size()), Character.toString(randomChar()));
            } else {
                int temp = options.get(rand.nextInt(options.size()));
                if (temp == 1) {
                    pass.add(rand.nextInt(pass.size()), Character.toString(randomSpecial()));
                } else if (temp == 2) {
                    pass.add(rand.nextInt(pass.size()), Character.toString(randomUppercase()));
                } else if (temp == 3) {
                    pass.add(rand.nextInt(pass.size()), Character.toString(randomLowercase()));
                } else {
                    pass.add(rand.nextInt(pass.size()), Character.toString(randomNumber()));
                } // if
            } // if
        } while (pass.stream().reduce("", (a, b) -> a + b).length() < 7);
        return pass.stream().reduce("", (a, b) -> a + b);
    } // generatePassword

    /**
     * Returns a random character.
     * The random character will be from the following ASCII table values:
     * ASCII Index 33, 35-38, 42, 48-57, 63-90, 97-122
     * @return A random character based on the specified valid characters.
     */
    public static char randomChar() {
        char c = (char) (rand.nextInt(89) + '!');
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
     * @return A random number.
     */
    public static char randomNumber() {
        return (char) (rand.nextInt(10) + '0');
    } // randomNumber

    /**
     * Returns a random special character.
     * The list of special characters that this method may return are:
     * ASCII Index 33, 35-38, 42, 63, 64, and 126
     * @return A random special character based on the specified valid characters.
     */
    public static char randomSpecial() {
        int[] list = new int[] {33, 35, 36, 37, 38, 42, 63, 64, 126};
        return (char) (list[rand.nextInt(9)]);
    } // randomSpecial

    /**
     * Returns a random uppercase character.
     * @return A random uppercase character.
     */
    public static char randomUppercase() {
        return (char) (rand.nextInt(26) + 'A');
    } // randomUppercase

    /**
     * Returns a random lowercase character.
     * @return A random lowercase character.
     */
    public static char randomLowercase() {
        return (char) (rand.nextInt(26) + 'a');
    } // randomLowercase
} // StringFormer
