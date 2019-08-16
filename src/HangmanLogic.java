import java.util.ArrayList;

public class HangmanLogic {
    // fields
    private String word = "test", guessedWord ="";
    private ArrayList<Character> correctInputs;
    private ArrayList<Character> incorrectInputs;
    private HangmanDisplay display;

    // constructors
    public HangmanLogic(){
        this.display = new HangmanDisplay();
        // what will be displayed in place of the hangman word
        for(int index=0; index<this.word.length(); index++){
            this.guessedWord+= "-";
        }
    }

    // method for input validation
    public boolean isInputCorrect(char input){
        char[] wordChar = this.word.toCharArray();
        for(int index=0; index<wordChar.length; index++){
            if(input == wordChar[index]){
                return true;
            }
        }
        return false;
    }

    // what to do with input
    public void whatToDoWithInput(char input){
        // if input matches character in hangman word: add the input to the list and display all correctly guessed letters
        if(this.correctInputs.contains(input) || this.incorrectInputs.contains(input)){
            display.letterAlreadyGuessed();
            return;
        }

        if(isInputCorrect(input)){
            this.correctInputs.add(input);
            display.displayCorrectInputs(correctlyGuessedLetters(input));
        }
        else{
            this.incorrectInputs.add(input);
            display.displayHangman();
            display.displayWrongInputs(incorrectlyGuessedLetters());
        }
    }

    // correctly guessed letters
    public String correctlyGuessedLetters(char input){
        char[] hangmanWordArr = this.word.toCharArray();
        char[] guessedWordArr = this.guessedWord.toCharArray();
        for(int index=0; index<hangmanWordArr.length; index++){
            if(input == hangmanWordArr[index]){
                guessedWordArr[index] = input;
            }
        }
        this.guessedWord = String.copyValueOf(guessedWordArr);
        return this.guessedWord;
    }

    // incorrectly guessed letters
    public String incorrectlyGuessedLetters(){
        String incorrectChar = "";
        for(char character: this.incorrectInputs){
            incorrectChar += character;
        }
        return incorrectChar;
    }

    // run program
    public void programStart(){


    }


}
