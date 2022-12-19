import java.util.Random;

public class NumberGuesser extends Game {

    private int SecretNum;
    private int GuessTracker;
    private int maxNum; 
    private Random ranges;
    private int limitGuess;
    private boolean guessed;
    /** Initalizes the random range, maximum number and the maximum amount of guesses the user can make. */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses){
        maxNum = maxNumber;
        ranges = rng;
        limitGuess = maxGuesses;
    }
    /** This gets the name of the game which is Number Guesser. */
    public String getName(){
        return "Number Guesser";
    }
    /** This prepares the user to play by setting a random number and returns to the user which the game has started. */
    public String prepToPlay(){
        GuessTracker = 0;
        guessed = false;
        SecretNum = ranges.nextInt(maxNum) + 1;
        return "I've picked a number 1 to " + maxNum + ". You get " + limitGuess + " guesses to guess it";
    }
    /** A move is valid only if the character the  */
    public boolean isValid(String move){
        if (move.isEmpty()){
            return false;
        }
        for (int i = 0; i < move.length(); i++){
            if(!Character.isDigit(move.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /** This processes the move the user inputs and it outputs whether the number is too high, too low or that they got it */
    public String processMove(String move){
        GuessTracker += 1;
        int i = Integer.parseInt(move);
        if (i == SecretNum) {
            guessed = true;
            return "That's it!";
        }
        else if (i > SecretNum){
            return "Too High";
        }
        else {
            return "Too Low";
        }

    }
    /** Whether you get it right or wrong it lets the user know if they failed if they reach their max guesses or that they get it right as well */
    public boolean isOver(){
        if (guessed){
            return true;
        }
        else if (GuessTracker >= limitGuess) {
            return true;
        }
        return false;
    }
    /** Returns the secret number to the end user */
    public String finalMessage(){
        return "The number was: " + SecretNum;
    }
}