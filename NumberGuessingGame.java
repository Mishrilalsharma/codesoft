import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        boolean playAgain;

        do {
            int targetNumber = rand.nextInt(100) + 1; 
            int attempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 10;

            System.out.println("A number between 1 and 100 has been chosen. Try to guess it!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + targetNumber);
            }

            totalScore += (maxAttempts - attempts) > 0 ? (maxAttempts - attempts) : 0;
            System.out.println("Your score for this round: " + (maxAttempts - attempts));
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        sc.close();
    }
}