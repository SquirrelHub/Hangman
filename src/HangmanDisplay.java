import javax.swing.*;
import java.util.ArrayList;

public class HangmanDisplay {

    private ArrayList<Character> wrongInputs;
    private HangmanLogic hLogic;
    private String placeholderWord="";
    private String[] man = {"  0","\n  /","|","\\","\n_", "/", " \\", "_"};
    private String figure = "", wrongVals ="";
    private int index = 0;

    public HangmanDisplay(){
        this.hLogic = new HangmanLogic();
    }

    // Get input from user
    public char getCharInput(){
        char input = (JOptionPane.showInputDialog("Please guess a letter:")).charAt(0);
        return input;
    }

    public void displayHangman(){
        this.figure += man[index];
        JOptionPane.showMessageDialog(null, figure);
        index++;
    }

    public void displayWrongInputs(String word){
        JOptionPane.showMessageDialog(null, wrongVals);
    }

    public void displayCorrectInputs(String word){
        JOptionPane.showMessageDialog(null, word);
    }

    public void letterAlreadyGuessed(){
        JOptionPane.showMessageDialog(null, "Letter is already guessed");
    }
}
