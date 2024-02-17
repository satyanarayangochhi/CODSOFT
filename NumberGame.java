/*TASK1- NUmber Game
 * Author - Satya Narayan Gochhi
 * NumberGame
 */

 import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); 

        int min = 1;
        int max = 100;

        System.out.println("\nWelcome to Satya's Number Game!");

        int maxAttempts = 8;
        int roundsWon = 0;

        while (true) {
            int target = generateNew(random, min, max);
            int attempts = 0;
            boolean Guess = false;

            System.out.println("\nI am thinking about a number buddy.\nGuess the number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts left.");

            while (attempts < maxAttempts && !Guess) {
                int userGuess = getUserGuess(scanner, min, max);

                if (userGuess == target) {
                    Guess = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundsWon++;
                } else if (userGuess < target) {
                    System.out.println("Too low! Guess higher.");
                } else {
                    System.out.println("Too high! Guess lower.");
                }

                attempts++;
            }

            if (!Guess) {
                System.out.println("\nBetter luck next time! You have reached the maximum number of attempts. \nThe correct number was: " + target);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nThanks for playing! \nYour total score is: " + roundsWon+"\n");
        scanner.close();
    }

    private static int generateNew(Random random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess(Scanner scanner, int min, int max) {
        int userGuess;

        do {
            System.out.print("\nEnter your guess: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }

            userGuess = scanner.nextInt();

            if (userGuess < min || userGuess > max) {
                System.out.println("Out of range! Please enter a number between " + min + " and " + max + ".");
            }
        } 
        while (userGuess < min || userGuess > max);

        return userGuess;
    }
}