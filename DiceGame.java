import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * My program rolls a die.
 *
 * @author  Kent Gatera
 * @version 1.0
 * @since   2024-March-18
 */

public final class DiceGame {

    /**
    * Pleases the style checker.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */

    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is where the main code will be.
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final Random rand = new Random();
        final int maxNum = 6;
        ArrayList<Integer> guessList = new ArrayList<>();
        // Input prompt from user.
        System.out.print("Guess a number 1-6: ");
        // Generating a number 1-6. (+1 to include 1 and 6)
        final int randNum = rand.nextInt(maxNum) + 1;
        try {
            for (int counter = 0; counter < maxNum; counter++) {
                final int userGuessInt = in.nextInt();
                if (userGuessInt == randNum) {
                    System.out.println("You are correct!");
                    final int listSize = guessList.size();
                    System.out.printf("You guessed wrong %d times: "
                        + guessList + "\n", listSize);
                    break;
                }
                if (userGuessInt < randNum) {
                    System.out.print("Guess higher.\n>>");
                    guessList.add(userGuessInt);
                }
                if (userGuessInt > randNum) {
                    System.out.print("Guess lower.\n>>");
                    guessList.add(userGuessInt);
                }
            }
        } catch (Exception e) {
            // To handle exception
            System.out.println("Guess a valid number 1-6");
        }
        in.close();
    }
}
