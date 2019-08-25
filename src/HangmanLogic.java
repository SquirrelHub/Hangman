import java.util.ArrayList;
import java.util.List;

public class HangmanLogic {
    String word = "test";
    List<String> badLetters = new ArrayList<>();
    List<String> goodLetters = new ArrayList<>();

    boolean isGameOver(){
        return goodLetters.size() == word.length() || badLetters.size() == 10 ? true : false;
    }

    void guessChar (Character c){
        if (badLetters.contains(c.toString()) || goodLetters.contains(c.toString())){
            return;
        }
        boolean found = false;
        for(Character letter : word.toCharArray()){
            if (letter == c){
                goodLetters.add(c.toString());
                found = true;
                return;
            }
        }
        if (!found){
            badLetters.add(c.toString());
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getBadLetters() {
        return badLetters;
    }

    public List<String> getGoodLetters() {
        return goodLetters;
    }
}
