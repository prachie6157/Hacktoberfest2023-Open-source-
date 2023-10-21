import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static String chooseWord() {
        String[] wordList = {"python", "javascript", "java", "programming", "computer", "algorithm", "hangman"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(wordList.length);
        return wordList[randomIndex];
    }

    public static void main(String[] args) {
        String wordToGuess = chooseWord();
        int wordLength = wordToGuess.length();
        int attempts = 6;  // Number of attempts allowed
        int incorrectGuesses = 0;
        StringBuilder guessedLetters = new StringBuilder();

        System.out.println("Welcome to Hangman!");

        while (true) {
            StringBuilder displayWord = new StringBuilder();
            for (int i = 0; i < wordToGuess.length(); i++) {
                char letter = wordToGuess.charAt(i);
                if (guessedLetters.toString().contains(String.valueOf(letter))) {
                    displayWord.append(letter);
                } else {
                    displayWord.append("_");
                }
            }

            System.out.println("Word to guess: " + displayWord);
            System.out.println("Guessed letters: " + guessedLetters.toString());
            System.out.println("Attempts left: " + attempts);

            if (displayWord.toString().equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }

            if (attempts == 0) {
                System.out.println("You've run out of attempts. The word was: " + wordToGuess);
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Guess a letter: ");
            String guess = scanner.next().toLowerCase();

            if (guessedLetters.toString().contains(guess)) {
                System.out.println("You've already guessed that letter.");
            } else if (wordToGuess.contains(guess)) {
                System.out.println("Good guess!");
                guessedLetters.append(guess);
            } else {
                System.out.println("Incorrect guess.");
                guessedLetters.append(guess);
                incorrectGuesses++;
                attempts--;
                drawHangman(incorrectGuesses);
            }
        }
    }

    private static void drawHangman(int incorrectGuesses) {
        String[] hangmanPics = {
            "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "/|   |\n" +
            "    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "/|\\  |\n" +
            "    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "/|\\  |\n" +
            "/    |\n" +
            "    |\n" +
            "======",

            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "/|\\  |\n" +
            "/ \\  |\n" +
            "    |\n" +
            "======"
        };
        System.out.println(hangmanPics[incorrectGuesses]);
    }
}
