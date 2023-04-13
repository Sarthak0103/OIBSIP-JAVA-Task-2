import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1; // minimum number in the range
        int maxRange = 100; // maximum number in the range
        int maxAttempts = 5; // maximum number of attempts allowed
        int score = 0; // user's score
        int round = 1; // current round

        JOptionPane.showMessageDialog(null, "Guess the Number Game!");

        // continue playing rounds until user chooses to quit
        while (true) {
            JOptionPane.showMessageDialog(null, "Round " + round + "\nYou have " + maxAttempts + " attempts.");

            // generate random number
            Random rand = new Random();
            int randomNumber = rand.nextInt(maxRange - minRange + 1) + minRange;

            // loop for user attempts
            for (int i = 1; i <= maxAttempts; i++) {
                // prompt user to enter their guess
                String guessString = JOptionPane.showInputDialog("Enter your guess (between " + minRange + " and " + maxRange + "):");
                int guess = Integer.parseInt(guessString);

                // check if guess is correct
                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations, you guessed the number in " + i + " attempts!");
                    score += (maxAttempts - i + 1);
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }

                // check if user has used all attempts
                if (i == maxAttempts) {
                    JOptionPane.showMessageDialog(null, "Sorry, you ran out of attempts. The number was " + randomNumber + ".");
                }
            }

            // ask user if they want to play another round
            int option = JOptionPane.showConfirmDialog(null, "Round " + round + " ended.\nYour score is " + score + ".\nDo you want to play another round?", "Guess the Number", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                round++;
            } else {
                JOptionPane.showMessageDialog(null, "Thanks for playing!\nFinal score: " + score);
                break;
            }
        }
    }
}

