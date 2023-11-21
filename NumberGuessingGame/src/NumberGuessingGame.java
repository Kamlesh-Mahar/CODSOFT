import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
                System.out.print("Enter your guess (Attempt " + attempt + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += numberOfAttempts - (attempt - 1);
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == numberOfAttempts) {
                    System.out.println("Out of attempts. The correct number was: " + generatedNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                System.out.println("Thanks for playing! Your total score is: " + score);
            }
        } while (scanner.hasNext() && scanner.next().toLowerCase().equals("yes"));

        scanner.close();
    }
}
