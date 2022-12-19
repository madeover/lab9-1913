
public class Hangman extends Game{

    private int guessTracker; 
    private String secretWord;
    private int maxiGuess;
    private int minLen;
    private int maxLen;
    private boolean[] isDone;
    private WordsList word;

    /** Initalizes the words for the parameters in the constructor */
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses){
        this.maxiGuess = maxGuesses;
        this.minLen = minWordLen;
        this.maxLen = maxWordLen;
        this.word = words;
    }
    /** Returns the name of the game name */
    public String getName(){
        return "Hangman";
    }
    /** Initializes a secret word here and then it prepares the user for the game as well to let them know that a game is about to start */
    public String prepToPlay(){
        guessTracker = 0;
        secretWord = word.getWord(minLen, maxLen);
        isDone = new boolean[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++){
            isDone[i] = false;
        }
        return "I've picked a " + secretWord.length() + " letter word. Guess letters you think are in the word. You get " + maxiGuess + " guesses.";

    }
    public boolean isOver(){
        if (guessTracker == maxiGuess){
            return true;
        }
        for (int i = 0; i < isDone.length; i++){
            if(!isDone[i]){
                return false;
            }
        }
        return true;
    }
    /** Move is valid if the */
    public boolean isValid(String move){
        if (move.length() > 1){
            return false;
        }
        return true;
    }
    /** This loops through the cluestring and changes the underscore to a letter if the move is correct */
    public String processMove (String move){
        guessTracker += 1;
        for (int j = 0; j < secretWord.length(); j++){
            if(secretWord.charAt(j) == move.charAt(0)){
                isDone[j] = true;
            }
        }
        String myReturn = "";
        for (int j = 0; j < secretWord.length(); j++){
            if(isDone[j]){
                myReturn += secretWord.charAt(j);
            }
            else {
                myReturn += "_";
            }
        }
        return myReturn;
    }
    /** Returns the hangman word at the end of the game.*/
    public String finalMessage(){
        return "The word was: " + secretWord; 
    }
}